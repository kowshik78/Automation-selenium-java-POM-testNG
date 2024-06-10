package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class ChangeBillingAddress extends BasePage {
    public ChangeBillingAddress(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By billingAddress = By.cssSelector("a[data-ui-id='default-billing-edit-link'] span");
    private final By street1 = By.cssSelector("#street_1");
    private final By city = By.cssSelector("#city");
    private final By region = By.name("region_id");
    private final By zip = By.cssSelector("#zip");
    private final By country = By.name("country_id");
    private final By telephone = By.name("telephone");
    private final By save_button = By.cssSelector("button[title='Save Address']");

    public WebElement getbillingAddress(){return elementWithWait(billingAddress,"visibility");}
    public WebElement getstreet1(){return elementWithWait(street1,"visibility");}
    public WebElement getcity(){return elementWithWait(city,"visibility");}
    public WebElement getregion(){return elementWithWait(region,"clickable");}
    public WebElement getzip(){return elementWithWait(zip,"visibility");}
    public WebElement getcountry(){return elementWithWait(country,"clickable");}
    public WebElement gettelephone(){return elementWithWait(telephone,"visibility");}
    public WebElement getsave_button(){return elementWithWait(save_button,"visibility");}

}