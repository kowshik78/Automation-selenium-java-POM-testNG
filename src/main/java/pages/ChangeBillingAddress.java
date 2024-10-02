package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeBillingAddress extends BasePage {

    @FindBy(css = "a[data-ui-id='default-billing-edit-link'] span") private WebElement billingAddress;
    @FindBy(css = "#street_1") private WebElement street1;
    @FindBy(css = "#city") private WebElement city;
    @FindBy(name = "region_id") private WebElement region;
    @FindBy(css = "#zip") private WebElement zip;
    @FindBy(name = "country_id") private WebElement country;
    @FindBy(name = "telephone") private WebElement telephone;
    @FindBy(css = "button[title='Save Address']") private WebElement saveButton;

    @FindBy(xpath = "//*[@class=\"box box-address-billing\"]//address") private WebElement assertAddress;

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

    public Map<String, String> printElementInfo() {
        Map<String, String> addressInfo = new HashMap<>();
        WebElement billingAddressElement = elementWithWait(assertAddress, "visibility");
        String outerHTML = billingAddressElement.getAttribute("outerHTML");

        String addressPattern = "(?<name>[^<]+)<br>\\s*(?<line2>[^<]+)<br>\\s*(?<city>[^,]+),\\s*(?<state>[^,]+),\\s*(?<zipcode>[^<]+)<br>\\s*(?<country>[^<]+)<br>\\s*T:\\s*<a[^>]+>(?<phone>[^<]+)</a>";
        Pattern pattern = Pattern.compile(addressPattern);
        Matcher matcher = pattern.matcher(outerHTML);
        if (matcher.find()) {
            addressInfo.put("street1", matcher.group("line2").trim());
            addressInfo.put("city", matcher.group("city").trim());
            addressInfo.put("state", matcher.group("state").trim());
            addressInfo.put("zipcode", matcher.group("zipcode").trim());
            addressInfo.put("country", matcher.group("country").trim());
            addressInfo.put("telephone", matcher.group("phone").trim());
        } else {
            System.out.println("No address information found in the provided HTML.");
        }

        return addressInfo;
    }
}
