package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.cartAdd;

import java.util.List;
import java.util.Random;

import static utils.Constant.*;

public class cartAddTest extends BaseTest {

    @Test
    public void addToCart() throws Exception {
        List<WebElement> dressSizes = page.getInstance(cartAdd.class).getSize();
        Random rand = new Random();
        int size = rand.nextInt(dressSizes.size());
        dressSizes.get(size).click();

        List<WebElement> dressColors = page.getInstance(cartAdd.class).getColor();
        int color = rand.nextInt(dressColors.size());
        dressColors.get(color).click();

        page.getInstance(cartAdd.class).getSubmitBtn().click();
    }
}
