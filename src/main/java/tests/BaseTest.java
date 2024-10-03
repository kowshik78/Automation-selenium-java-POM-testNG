package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.Page;
import utils.ConfigProperties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    public static String resourcesRoot = "./resources/";
    FluentWait wait;
    public static Page page;

    @BeforeSuite
    @Parameters(value = {"browser"})
    public void setupTest(String browser) throws IOException {

        ConfigProperties conf = new ConfigProperties();
        String url = conf.config.getProperty("BASE_URL");

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver",resourcesRoot+"drivers\\chromedriver_126.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();

            System.out.println("Chrome Browser is Selected");
        }

        wait = new FluentWait(driver);
        page = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        driver.get(url);
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("TIMEOUT_IN_SECONDS"))));
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("POLLING_IN_MILLISECONDS"))));
    }

    public void tearDown(){driver.quit();}
    public void takeScreenshot(String stepName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + stepName + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) { e.printStackTrace(); }
    }
}