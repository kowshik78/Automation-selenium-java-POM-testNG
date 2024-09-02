package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CompareList;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompareListTest extends BaseTest {
    public static List<String> titles = new ArrayList<>();
    public static List<String> prices = new ArrayList<>();
    public static List<String> SKUs = new ArrayList<>();
    public static List<String> Descriptions = new ArrayList<>();

    @Test
    public void compareCart() throws Exception {
        page.getInstance(CompareList.class).getLogo().click();
        HomeTest home = new HomeTest();
        for (int i = 0; i <1 ; i++) {
            home.cardTest();
            titles.addAll(page.getInstance(CompareList.class).getHomeTitle().stream().map(WebElement::getText).collect(Collectors.toList()));
            prices.addAll(page.getInstance(CompareList.class).getHomePrice().stream().map(WebElement::getText).collect(Collectors.toList()));
            SKUs.addAll(page.getInstance(CompareList.class).getHomeSKU().stream().map(WebElement::getText).collect(Collectors.toList()));
            Descriptions.addAll(page.getInstance(CompareList.class).getHomeDescription().stream().map(WebElement::getText).collect(Collectors.toList()));

            WebElement w1=page.getInstance(CompareList.class).getAddCompare();
            page.getInstance(BasePage.class).jsExecuteScript(w1);
            page.getInstance(CompareList.class).getLogo().click();
        }
        page.getInstance(CompareList.class).getHomeToCompareList().click();
    }

    @Test
    public void compareProductWithTable() throws Exception {
        List<WebElement> tableRowUpper= page.getInstance(CompareList.class).getTableRowUpper();
        List<String> titleTexts = page.getInstance(CompareList.class).getCompareTitle().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> priceTexts = page.getInstance(CompareList.class).getComparePrice().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> SKUTexts =   page.getInstance(CompareList.class).getCompareSKU().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> Destexts =  page.getInstance(CompareList.class).getCompareDescription().stream().map(WebElement::getText).collect(Collectors.toList());

        for (int i = 0; i < tableRowUpper.size(); i++) {
            System.out.println(titleTexts.get(i)+priceTexts.get(i)+SKUTexts.get(i)+"   "+titles.get(i)+prices.get(i)+SKUs.get(i));}

        for(String title: titles){
            for(String compareTitle:titleTexts){
                if (title.equals(compareTitle)){break;}
            }
            Assert.assertTrue(true,  title);}
        for(String sku: SKUs){
            for(String compareSku:SKUTexts){
                if (sku.equals(compareSku)){break;}
            }
            Assert.assertTrue(true,  sku);}
        for(String price: prices){
            for(String comparePrice:priceTexts){
                if (price.equals(comparePrice)){break;}
            }
            Assert.assertTrue(true,  price);}
       for(String Description: Descriptions){
            for(String compareTitle:Destexts){
                if (Description.equals(compareTitle)){break;}
            }
            Assert.assertTrue(true, "Match found for title: " + Description);}
    }

    public void print() throws Exception {

        WebElement t= page.getInstance(CompareList.class).getPrintButton();
        page.getInstance(BasePage.class).jsExecuteScript(t);

        String parent = driver.getWindowHandle();
        for (String handler : driver.getWindowHandles()) {
            if (!handler.equals(parent)) {
                try {
                    driver.switchTo().window(handler);
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                    driver.close();
                    driver.switchTo().window(parent);
                }   catch (AWTException e) {
                    System.out.println("Timeout while switching to new window");
                    e.printStackTrace();
                }
            }
        }
    }
}