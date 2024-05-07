package tests;

import java.io.*;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.Page;
import utils.ConfigProperties;


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
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver",resourcesRoot+"drivers\\chromedriver_124.exe");
            driver = new ChromeDriver();
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
}