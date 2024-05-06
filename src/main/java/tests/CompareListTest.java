package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareList;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 0; i <10 ; i++) {
            home.cardTest();

            String title = page.getInstance(CompareList.class).getHomeTitle().getText();titles.add(title);
            String price = page.getInstance(CompareList.class).getHomePrice().getText();prices.add(price);
            String SKU = page.getInstance(CompareList.class).getHomeSKU().getText();SKUs.add(SKU);
            String Description = page.getInstance(CompareList.class).getHomeDescription().getText();Descriptions.add(Description);
            System.out.println(title);
            page.getInstance(CompareList.class).getAddCompare().click(); Thread.sleep(2000);
            page.getInstance(CompareList.class).getLogo().click();
        }
        page.getInstance(CompareList.class).getHomeToCompareList().click();
    }

    @Test
    public void compareProductWithTable() throws Exception {
        List<WebElement> tableRowUpper= driver.findElements(By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td"));

            List<WebElement> tableTitle = driver.findElements(By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td/strong"));
            List<WebElement> tablePrice = driver.findElements(By.xpath("//*[contains(@class, 'price-wrapper')]"));
            List<WebElement> tableSKU = driver.findElements(By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[1]/td"));
            List<WebElement> tableDescription = driver.findElements(By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[2]/td"));

            List<String> titleTexts = tableTitle.stream().map(WebElement::getText).collect(Collectors.toList());
            List<String> priceTexts = tablePrice.stream().map(WebElement::getText).collect(Collectors.toList());
            List<String> SKUTexts = tableSKU.stream().map(WebElement::getText).collect(Collectors.toList());
            List<String> descriptionTexts = tableDescription.stream().map(WebElement::getText).collect(Collectors.toList());

        for (int i = 0; i < tableRowUpper.size(); i++) {
            int closestMatchIndex = findClosestMatchIndex(titleTexts.get(i), titles);
            Assert.assertEquals(titleTexts.get(i), titles.get(closestMatchIndex), "Title mismatch");
            Assert.assertEquals(priceTexts.get(i), prices.get(closestMatchIndex), "Price mismatch");
            Assert.assertEquals(SKUTexts.get(i), SKUs.get(closestMatchIndex), "Price mismatch");
            Assert.assertEquals(descriptionTexts.get(i), Descriptions.get(closestMatchIndex), "Price mismatch");
        }
    }

    private int findClosestMatchIndex(String s1, List<String> listTitles){
        int closestIndex = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < listTitles.size(); i++) {
            String s2 = listTitles.get(i);
            int m = s1.length(); int n = s2.length();

            int[][] dp = new int[m + 1][n + 1];
            for (int j = 0; j <= m; j++) {dp[j][0] = j;}
            for (int j = 0; j <= n; j++) {dp[0][j] = j;}

            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int cost = (s1.charAt(j - 1) == s2.charAt(k - 1)) ? 0 : 1;
                    dp[j][k] = Math.min(Math.min(dp[j - 1][k] + 1, dp[j][k - 1] + 1), dp[j - 1][k - 1] + cost);
                }
            }

            int distance = dp[m][n];
            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }
        return closestIndex;
    }
/*    @Test
    public void print() throws Exception {

        WebElement t= page.getInstance(CompareList.class).getPrintButton();
        t.click();

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
                } catch (AWTException e) {
                    System.out.println("Timeout while switching to new window");
                    e.printStackTrace();
                }
            }
        }
    }*/

}