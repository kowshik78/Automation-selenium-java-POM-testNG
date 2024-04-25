package tests;

import java.io.*;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import pages.BasePage;
import pages.Page;
import utils.ConfigProperties;

public class BaseTest {
    public static WebDriver driver;
    public static String resourcesRoot = "./resources/";// Set Path f resources
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

/*
    public void popupHandle() throws NoSuchElementException {
        try {
            WebElement close = page.getInstance(HomePage.class).getPopupCloseBtn();
            close.click();}
        catch (TimeoutException ignored){}
    }
    public static void takeScreenshot(WebDriver webDriver, String filePath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        //Call getScreenshotAs method to create image file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destinationFile = new File(filePath);
        //Copy file at destination
        FileUtils.copyFile(srcFile,destinationFile);
    }
*/

    public void WebElementListHandle(WebElement drop) throws NoSuchElementException{
        try {
            Select select = new Select(drop);
            List<WebElement> Types = select.getOptions();
            int size = Types.size();
            Random random = new Random();
            int randomIndex = random.nextInt(size);
            Types.get(randomIndex).click();
        }
        catch (TimeoutException ignored){}
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}