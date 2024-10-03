package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomDropList extends BasePage {
    public RandomDropList(WebDriver driver) throws InterruptedException, IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") private WebElement hoverWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/span[2]") private WebElement hoverTops;
    public WebElement getHoverWomen() {return elementWithWait(hoverWomen, "visibility");}
    public WebElement getHoverTops() {return elementWithWait(hoverTops, "visibility");}
    public WebElement getHoverTopsDropdown() {return elementWithWait(hoverTops(), "visibility");}

    public WebElement getMenuElement(String menu) throws NoSuchElementException {
        String menuXPath = String.format("//*[contains(text(), '%s')]", menu);
        return elementWithWait(By.xpath(menuXPath), "clickable");
    }
    public WebElement getSubmenuElement(String submenu) throws NoSuchElementException {
        String submenuXPath = String.format("(//*[contains(text(), '%s')])[1]", submenu);
        return elementWithWait(By.xpath(submenuXPath), "clickable");
    }
    public WebElement getSubsubmenuElement(String subsubmenu) throws NoSuchElementException {
        String subsubmenuXPath = String.format("(//*[contains(text(), '%s')])[1]", subsubmenu);
        return elementWithWait(By.xpath(subsubmenuXPath), "clickable");
    }

    @FindBy(xpath = "//div[contains(@class, 'shipping-address-item') and contains(@class, 'selected-item')]") private WebElement shippingAddress;
    public Map<String, String> printElementInfo() {
        Map<String, String> shippingAddressInfo = new HashMap<>();
        WebElement shippingAddressElement = elementWithWait(shippingAddress, "visibility");
        String fullText = shippingAddressElement.getText();
        String[] lines = fullText.split("\\n");

        shippingAddressInfo.put("street1", lines[1].trim());

        String[] cityStateZip = lines[2].split(", ");
        shippingAddressInfo.put("city", cityStateZip[0].trim());

        String[] stateZip = cityStateZip[1].split(" ");
        shippingAddressInfo.put("state", stateZip[0].trim());
        shippingAddressInfo.put("zipcode", stateZip[1].trim());

        shippingAddressInfo.put("country", lines[3].trim());
        shippingAddressInfo.put("telephone", lines[4].trim());

        /*String outerHTML = shippingAddressElement.getAttribute("outerHTML");
        String shippingAddressPattern = "(?<name>[A-Za-z0-9 ]+)<!-- /ko -->[^<]*<br>\\s*" + "(?<street>[^<]+)<br>\\s*" + "(?<city>[^,]+),\\s*" +
                "<span[^>]*>(?<state>[^<]+)</span>[^<]*" + "(?<zipcode>[^<]+)<br>\\s*" + "(?<country>[^<]+)<br>[^<]*" + "href=\"tel:[^\"]+\">(?<phone>[^\"]+)</a>";

        Pattern pattern = Pattern.compile(shippingAddressPattern);
        Matcher matcher = pattern.matcher(outerHTML);
        if (matcher.find()) {
            shippingAddressInfo.put("street1", matcher.group("street").trim());
            shippingAddressInfo.put("city", matcher.group("city").trim());
            shippingAddressInfo.put("state", matcher.group("state").trim());
            shippingAddressInfo.put("zipcode", matcher.group("zipcode").trim());
            shippingAddressInfo.put("country", matcher.group("country").trim());
            shippingAddressInfo.put("telephone", matcher.group("phone").trim());
        }*/
        return shippingAddressInfo;
    }

    @FindBy(xpath = "//*[text()=\"shopping cart\"]") private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]//ul/li[1]/button") private WebElement proceedButton;
    @FindBy(xpath = "//*[@value=\"flatrate_flatrate\"]") private WebElement radioButton;
    @FindBy(xpath = "//*[@class=\"button action continue primary\"]") private WebElement billingNextButton;
    @FindBy(xpath = "//*[text()=\"Place Order\"]") private WebElement placeOrderButton;
    @FindBy(xpath = "//*[@class=\"base\" and text()=\"Thank you for your purchase!\"]") private WebElement thanksText;
    @FindBy(xpath = "//*[contains(text(),\"Continue Shopping\")]") private WebElement continueShopping;
    public WebElement getCartButton() {return elementWithWait(cartButton, "clickable");}
    public WebElement getProceedButton() {return elementWithWait(proceedButton, "clickable");}
    public WebElement getRadioButton() {return elementWithWait(radioButton, "clickable");}
    public WebElement getBillingNextButton() {return elementWithWait(billingNextButton, "clickable");}
    public WebElement getPlaceOrderButton() {return elementWithWait(placeOrderButton, "clickable");}
    public WebElement getThanksText() {return elementWithWait(thanksText, "clickable");}
    public WebElement getContinueShopping() {return elementWithWait(continueShopping, "clickable");}


    @FindBy(css = "#opc-sidebar > div.opc-block-summary > table > tbody > tr.grand.totals > td > strong") private WebElement checkoutPrice;
    @FindBy(xpath = "//*[@class=\"checkout-success\"]/p/a/strong") private WebElement purchaseNumber;
    public WebElement getCheckoutPrice() {return elementWithWait(checkoutPrice, "clickable");}
    public WebElement getPurchaseNumber() {return elementWithWait(purchaseNumber, "clickable");}


    private By hoverTops() {
        Random rand = new Random();
        int randomId = 11 + rand.nextInt(4); // Generates a number between 12 and 14
        String randomXPath = String.format("//*[@id='ui-id-%d']/span[1]", randomId);
        return By.xpath(randomXPath);
    }
}
