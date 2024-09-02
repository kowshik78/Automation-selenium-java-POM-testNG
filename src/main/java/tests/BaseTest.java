package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.Page;
import utils.ConfigProperties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


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
            
            options.addArguments("--headless");
            driver = new ChromeDriver(); //remove options to remove headless
            System.out.println("Chrome Browser is Selected");
        }

        wait = new FluentWait(driver);
        page = new BasePage(driver);
        driver.manage().window().maximize();
        driver.get(url);
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("TIMEOUT_IN_SECONDS"))));
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("POLLING_IN_MILLISECONDS"))));
    }

    public void tearDown(){
        driver.quit();
    }


    public static void loginCheck() throws Exception {
            LoginTest lg = new LoginTest();
            if(driver.findElement(By.className("authorization-link")).getText().equals("Sign In")) {
                lg.LoggedinTest();
            }
            else{ System.out.println("Already logged in"); }
        }

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