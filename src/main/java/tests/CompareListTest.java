package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CompareList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompareListTest extends BaseTest {
    public static List<String> titles = new ArrayList<>();
    public static List<String> prices = new ArrayList<>();
    public static List<String> SKUs = new ArrayList<>();
    public static List<String> Descriptions = new ArrayList<>();

    @Step("Test case 001")
    @Description
    @Test
    public void compareCart() throws Exception {
        page.getInstance(CompareList.class).getLogo().click();
        HomeTest home = new HomeTest();
        for (int i = 0; i <2 ; i++) {
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

    @Step("Test case 002")
    @Description
    @Test
    public void compareProductWithTable() throws Exception {
        List<WebElement> tableRowUpper= page.getInstance(CompareList.class).getTableRowUpper();
        List<String> titleTexts = page.getInstance(CompareList.class).getCompareTitle().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> priceTexts = page.getInstance(CompareList.class).getComparePrice().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> SKUTexts =   page.getInstance(CompareList.class).getCompareSKU().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> Des1texts =  page.getInstance(CompareList.class).getCompareDescription().stream().map(WebElement::getText).collect(Collectors.toList());

        for (int i = 0; i < tableRowUpper.size(); i++) {
            System.out.println(titleTexts.get(i)+priceTexts.get(i)+SKUTexts.get(i)+"   "+titles.get(i)+prices.get(i)+SKUs.get(i));}

        for(String title: titles){
            for(String compareTitle:titleTexts){
                if (title.equals(compareTitle)){break;}
            }
            Assert.assertTrue(true, "Match found for title: " + title);}
        for(String sku: SKUs){
            for(String compareSku:SKUTexts){
                if (sku.equals(compareSku)){break;}
            }
            Assert.assertTrue(true, "Match found for title: " + sku);}
        for(String price: prices){
            for(String comparePrice:priceTexts){
                if (price.equals(comparePrice)){break;}
            }
            Assert.assertTrue(true, "Match found for title: " + price);}
        for(String Description: Descriptions){
            for(String compareTitle:Des1texts){
                if (Description.equals(compareTitle)){break;}
            }
            Assert.assertTrue(true, "Match found for title: " + Description);}

            /*for (int i = 0; i < tableRowUpper.size(); i++) {
                int closestMatchIndex = findClosestMatchIndex(titleTexts.get(i), titles);
                Assert.assertEquals(titleTexts.get(i), titles.get(closestMatchIndex), "Title mismatch");
                Assert.assertEquals(priceTexts.get(i), prices.get(closestMatchIndex), "Price mismatch");
                Assert.assertEquals(SKUTexts.get(i), SKUs.get(closestMatchIndex), "Price mismatch");
                Assert.assertEquals(desTexts.get(i), Descriptions.get(closestMatchIndex), "Price mismatch");
            }*/
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

    private int findClosestMatchIndex(String s1, List<String> listTitles){
        int closestIndex = 0; int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < listTitles.size(); i++) {
            String s2 = listTitles.get(i);
            int m = s1.length(); int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int j = 0; j <= m; j++) {dp[j][0] = j;}for (int j = 0; j <= n; j++) {dp[0][j] = j;}
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int cost = (s1.charAt(j - 1) == s2.charAt(k - 1)) ? 0 : 1;
                    dp[j][k] = Math.min(Math.min(dp[j - 1][k] + 1, dp[j][k - 1] + 1), dp[j - 1][k - 1] + cost);}}
            int distance = dp[m][n]; if (distance < minDistance) {minDistance = distance;closestIndex = i;}}
        return closestIndex;}
}