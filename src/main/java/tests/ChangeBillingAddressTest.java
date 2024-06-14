package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ChangeBillingAddress;
import pages.ChangePassword;

import java.util.List;
import java.util.Random;

import static utils.Constant.*;

public class ChangeBillingAddressTest extends BaseTest {

    @Test
    public void changeDefaultBillingAddressTest() throws Exception {
        page.getInstance(ChangePassword.class).getBillingAddress().click();

        page.getInstance(ChangeBillingAddress.class).getStreet1().sendKeys(street1);
        page.getInstance(ChangeBillingAddress.class).getCity().sendKeys(city);
        WebElement RegionDropdown = page.getInstance(ChangeBillingAddress.class).getRegion();
        WebElementListHandle(RegionDropdown);

        page.getInstance(ChangeBillingAddress.class).getZip().sendKeys(zip);
        WebElement countryDropdown = page.getInstance(ChangeBillingAddress.class).getCountry();
        WebElementListHandle(countryDropdown);

        page.getInstance(ChangeBillingAddress.class).getTelephone().sendKeys(telephone);
        page.getInstance(ChangeBillingAddress.class).getSaveButton().click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
    }

    private void WebElementListHandle(WebElement drop) throws NoSuchElementException {
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



}