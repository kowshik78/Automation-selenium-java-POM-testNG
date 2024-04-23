package tests;

import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.Page;
//import pages.Page;

public class HomeTest extends BaseTest{

    @Test
    public void locatorTest() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Test Start .......");

        String pageTitle = driver.getTitle(); //Get the page title
        System.out.println("Page title is: "+pageTitle);
        String current_url = driver.getCurrentUrl();
        System.out.println("Current url is: "+current_url);
        softAssert.assertEquals(current_url,"BASE_URL");

        page.getInstance(HomePage.class).getcreateAccountBtn().click();

    }
}