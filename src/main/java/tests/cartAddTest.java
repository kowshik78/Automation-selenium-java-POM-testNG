package tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.cartAdd;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class cartAddTest extends BaseTest {

    @Test
    public void addToCart() throws Exception {

        if(!page.getInstance(cartAdd.class).getSize().isEmpty()){
            List<WebElement> dressSizes = page.getInstance(cartAdd.class).getSize();
            List<WebElement> dressColors = page.getInstance(cartAdd.class).getColor();

            Random rand = new Random();
            int size = rand.nextInt(dressSizes.size());
            int color = rand.nextInt(dressColors.size());
            dressSizes.get(size).click();
            dressColors.get(color).click();

            page.getInstance(cartAdd.class).getSubmitBtn().click();
        } else
        {
            page.getInstance(cartAdd.class).getSubmitBtn().click();
        }
        Thread.sleep(5000);
    }

    @Test
    public void removeCart() throws Exception {
        WebDriverWait retryWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page.getInstance(cartAdd.class).getcartButton().click();
        Thread.sleep(3000);

        List<WebElement> productsToDelete = page.getInstance(cartAdd.class).getproductdelete();
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
