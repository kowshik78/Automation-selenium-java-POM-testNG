package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChangeBillingAddress;
import pages.ChangePassword;
import pages.Page;

import static utils.Constant.*;

public class ChangeBillingAddressTest extends BaseTest {

    @Test
    public void changeDefaultBillingAddressTest() throws Exception {
        page.getInstance(ChangePassword.class).getbillingAddress().click();

        page.getInstance(ChangeBillingAddress.class).getstreet1().sendKeys(street1);
        page.getInstance(ChangeBillingAddress.class).getcity().sendKeys(city);
        WebElement RegionDropdown = page.getInstance(ChangeBillingAddress.class).getregion();
        WebElementListHandle(RegionDropdown);

        page.getInstance(ChangeBillingAddress.class).getzip().sendKeys(zip);
        WebElement countryDropdown = page.getInstance(ChangeBillingAddress.class).getcountry();
        WebElementListHandle(countryDropdown);

        page.getInstance(ChangeBillingAddress.class).gettelephone().sendKeys(telephone);
        page.getInstance(ChangeBillingAddress.class).getsave_button().click();

    }
}