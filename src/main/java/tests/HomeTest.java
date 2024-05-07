package tests;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HomeTest extends BaseTest{

    @Test
    public void locatorTest() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        loginCheck();

        System.out.println("Page title is: "+driver.getTitle());
        System.out.println("Current url is: "+driver.getCurrentUrl());
        softAssert.assertEquals(driver.getCurrentUrl(),"BASE_URL");

    }

    @Test
    public void subscribeclickTest() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        page.getInstance(HomePage.class).getSubscriberSelector().click();
    }

    public void cardTest() throws Exception {
       List<WebElement> cards = page.getInstance(HomePage.class).getCardSelector();
       Random rand = new Random();
       int randomNum = rand.nextInt(cards.size());
       cards.get(randomNum).click();
       Thread.sleep(5000);
    }

    @Test
    public void brokenLinkTest() throws Exception {
        driver.get("https://magento.softwaretestingboard.com/");
        List<WebElement> links = page.getInstance(HomePage.class).getLinkSelector();
        int correctCount = 0;
        int incorrectCount = 0;
        int nullCount = 0;
        for (WebElement link : links) {
            String homeLink = link.getAttribute("href");
            if (homeLink!=null && !homeLink.isEmpty()){
                HttpURLConnection connection = (HttpURLConnection)new URL(homeLink).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK){
                    System.out.println(homeLink+" found & response code = "+responseCode);
                    correctCount++;
                }
                else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND){
                    System.out.println(homeLink+" not found & response code = "+responseCode);
                    incorrectCount++;
                }
            }
            else {
                System.out.println("Empty or null link found.");
                nullCount++;
            }
        }
        System.out.println("Correct count of links: "+correctCount);
        System.out.println("Incorrect count of links: "+incorrectCount);
        System.out.println("Empty or Null links count: "+nullCount);
    }

}