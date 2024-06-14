package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

public class RandomDropList extends BasePage {
    public RandomDropList(WebDriver driver) throws InterruptedException, IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]") private WebElement hoverWomen;
    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/span[2]") private WebElement hoverTops;
    /*@FindBy(xpath = "//*[@id=\"ui-id-10\"]/span[2]") private WebElement hoverBottoms;*/
    public WebElement getHoverWomen() {return elementWithWait(hoverWomen, "visibility");}
    public WebElement getHoverTops() {return elementWithWait(hoverTops, "visibility");}
    //public WebElement getHoverBottom() { return elementWithWait(hoverBottoms, "visibility"); }
    public WebElement getHoverTopsDropdown() {return elementWithWait(hoverTops(), "visibility");}
    //public WebElement getHoverBottomsDropdown() { return elementWithWait(hoverBottoms(), "visibility"); }


    @FindBy(xpath = "//*[text()=\"shopping cart\"]") private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]//ul/li[1]/button") private WebElement proceedButton;
    @FindBy(xpath = "//*[@class=\"button action continue primary\"]") private WebElement billingNextButton;
    @FindBy(xpath = "//*[text()=\"Place Order\"]") private WebElement placeOrderButton;
    @FindBy(xpath = "//*[@class=\"base\" and text()=\"Thank you for your purchase!\"]") private WebElement thanksText;
    @FindBy(xpath = "//*[contains(text(),\"Continue Shopping\")]") private WebElement continueShopping;
    public WebElement getCartButton() {return elementWithWait(cartButton, "clickable");}
    public WebElement getProceedButton() {return elementWithWait(proceedButton, "clickable");}
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
    /*private By hoverBottoms() {
        Random rand = new Random();
        int randomId = 15 + rand.nextInt(2);
        String randomXPath = String.format("//*[@id='ui-id-15']/span[1]", randomId);
        return By.xpath(randomXPath);
    }*/

}
