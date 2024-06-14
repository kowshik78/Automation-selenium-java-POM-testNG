package tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CompareList;
import pages.cartAdd;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class cartAddTest extends BaseTest {

    @Test
    public void logoTest() throws InterruptedException {
        page.getInstance(CompareList.class).getLogo().click();
    }

    @Test
    public void addToCart() throws Exception {
        HomeTest home = new HomeTest();
        home.cardTest();

        try{
            List<WebElement> dressSizes=page.getInstance(cartAdd.class).getSize();
            List<WebElement> dressColors=page.getInstance(cartAdd.class).getColor();
            Random rand = new Random();
            int size = rand.nextInt(dressSizes.size());
            int color = rand.nextInt(dressColors.size());

            page.getInstance(BasePage.class).jsExecuteScript(dressSizes.get(size));
            page.getInstance(BasePage.class).jsExecuteScript(dressColors.get(color));
            page.getInstance(cartAdd.class).getAddToCartBtn().click();
        }
        catch(Exception e)
        {page.getInstance(cartAdd.class).getAddToCartBtn().click();}
        Thread.sleep(5000);
    }

    @Test
    public void removeCart() throws Exception {
        WebDriverWait retryWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page.getInstance(cartAdd.class).getCartButton().click();
        Thread.sleep(3000);

        List<WebElement> productsToDelete = page.getInstance(cartAdd.class).getProductDelete();
        for (WebElement e : productsToDelete) {
            boolean clicked = false;
            while (!clicked) {
                try {
                    retryWait.until(ExpectedConditions.elementToBeClickable(e)).click();
                    clicked = true;
                } catch (StaleElementReferenceException ignored) {
                }
            }
            page.getInstance(cartAdd.class).getAlertConfirm().click();
        }
    }

}
