package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class ChangeBillingAddress extends BasePage {
    public ChangeBillingAddress(WebDriver driver) throws IOException {
        super(driver);
    }

    private By billingAddress = By.cssSelector("a[data-ui-id='default-billing-edit-link'] span");
    private By street1 = By.cssSelector("#street_1");
    private By city = By.cssSelector("#city");
    private By region = By.cssSelector("#region_id");
    private By zip = By.cssSelector("#zip");
    private By country = By.cssSelector("#country");
    private By telephone = By.name("telephone");
    private By save_button = By.cssSelector("button[title='Save Address']");

    public WebElement getbillingAddress(){return elementWithWait(billingAddress,"visibility");}
    public WebElement getstreet1(){return elementWithWait(street1,"visibility");}
    public WebElement getcity(){return elementWithWait(city,"visibility");}
    public WebElement getregion(){return elementWithWait(region,"visibility");}
    public WebElement getzip(){return elementWithWait(zip,"visibility");}
    public WebElement getcountry(){return elementWithWait(country,"visibility");}
    public WebElement gettelephone(){return elementWithWait(telephone,"visibility");}
    public WebElement getsave_button(){return elementWithWait(save_button,"visibility");}

}