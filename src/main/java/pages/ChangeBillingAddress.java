package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChangeBillingAddress extends BasePage {

    @FindBy(css = "a[data-ui-id='default-billing-edit-link'] span") private WebElement billingAddress;
    @FindBy(css = "#street_1") private WebElement street1;
    @FindBy(css = "#city") private WebElement city;
    @FindBy(name = "region_id") private WebElement region;
    @FindBy(css = "#zip") private WebElement zip;
    @FindBy(name = "country_id") private WebElement country;
    @FindBy(name = "telephone") private WebElement telephone;
    @FindBy(css = "button[title='Save Address']") private WebElement saveButton;

    public ChangeBillingAddress(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getBillingAddress() {return elementWithWait(billingAddress, "visibility");}
    public WebElement getStreet1() {return elementWithWait(street1, "visibility");}
    public WebElement getCity() {return elementWithWait(city, "visibility");}
    public WebElement getRegion() {return elementWithWait(region, "clickable");}
    public WebElement getZip() {return elementWithWait(zip, "visibility");}
    public WebElement getCountry() {return elementWithWait(country, "clickable");}
    public WebElement getTelephone() {return elementWithWait(telephone, "visibility");}
    public WebElement getSaveButton() {return elementWithWait(saveButton, "visibility");}
}
