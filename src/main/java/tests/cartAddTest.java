package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.cartAdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class cartAddTest extends BaseTest {

   public static List<String> titles = new ArrayList<>();
   public static List<String> prices = new ArrayList<>();

    public static List<String> titleTexts = new ArrayList<>();
    public static List<String> priceTexts = new ArrayList<>();

    @Test
    public void addToCart() throws Exception {
        for(int i=0;i<2;i++) {
            List<WebElement> multiProduct = page.getInstance(cartAdd.class).getProduct();
            Random rand = new Random();
            int size = rand.nextInt(multiProduct.size());
            multiProduct.get(size).click();
            titles.addAll(page.getInstance(cartAdd.class).getName().stream().map(WebElement::getText).collect(Collectors.toList()));
            prices.addAll(page.getInstance(cartAdd.class).getPrice().stream().map(WebElement::getText).collect(Collectors.toList()));
            page.getInstance(cartAdd.class).getCart().click();
            if(i<1){
                driver.get("https://www.saucedemo.com/inventory.html");
            }
        }
        System.out.println(titles);System.out.println(prices);
        page.getInstance(cartAdd.class).getCartPage().click();
    }

    @Test
    public void compareCart() throws Exception {
        titleTexts.addAll(page.getInstance(cartAdd.class).getCompareTitle().stream().map(WebElement::getText).collect(Collectors.toList()));
        priceTexts.addAll(page.getInstance(cartAdd.class).getComparePrice().stream().map(WebElement::getText).collect(Collectors.toList()));
        SoftAssert softAssert = new SoftAssert();
        for(String title: titles){
            for(String compareTitle:titleTexts){
                if (title.equals(compareTitle)){
                    softAssert.assertEquals(compareTitle, title);
                    break;}
            }
            Assert.assertTrue(true, "Match found for title: " + title);}
        for(String price: prices){
            for(String comparePrice:priceTexts){
                if (price.equals(comparePrice)){
                    softAssert.assertEquals(comparePrice, price);
                    break;}
            }
            Assert.assertTrue(true, "Match found for title: " + price);}
        softAssert.assertAll();
        page.getInstance(cartAdd.class).getCheckout().click();
        }
    }
