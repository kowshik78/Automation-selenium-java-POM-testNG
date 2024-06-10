package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.Random;

public class RandomDropList extends BasePage{
    public RandomDropList(WebDriver driver) throws InterruptedException, IOException {
        super(driver);
    }
    private final By hoverWomen = By.xpath("//*[@id=\"ui-id-4\"]/span[2]");
    private final By hoverTops = By.xpath("//*[@id=\"ui-id-9\"]/span[2]");
    private final By hoverBottoms= By.xpath("//*[@id=\"ui-id-10\"]/span[2]");
    private By hoverTops() {
        Random rand = new Random();
        int randomId = 11 + rand.nextInt(4); // Generates a number between 12 and 14
        String randomXPath = String.format("//*[@id='ui-id-%d']/span[1]", randomId);
        return By.xpath(randomXPath);
    }
/*    private By hoverBottoms() {
        Random rand = new Random();
        int randomId = 15 + rand.nextInt(2);
        String randomXPath = String.format("//*[@id='ui-id-15']/span[1]", randomId);
        return By.xpath(randomXPath);
    }*/

    public WebElement getHoverWomen(){
        return elementWithWait(hoverWomen,"visibility");
    }
    public WebElement getHoverTops(){return elementWithWait(hoverTops,"visibility");}
    //public WebElement getHoverBottom(){return elementWithWait(hoverBottoms,"visibility");}
    public WebElement getHoverTopsDropdown(){return elementWithWait(hoverTops(),"visibility");}
    //public WebElement getHoverBottomsDropdown(){return elementWithWait(hoverBottoms(),"visibility");}


    private final By cartButton=By.xpath("//*[text()=\"shopping cart\"]");
    private final By proceedButton=By.xpath("//*[@id=\"maincontent\"]//ul/li[1]/button");
    private final By billingNextButton=By.xpath("//*[@class=\"button action continue primary\"]/span[1]");
    private final By plcaeOrderButton=By.xpath("//*[text()=\"Place Order\"]");
    private final By thanksText=By.xpath("//*[@class=\"base\" and text()=\"Thank you for your purchase!\"]");
    private final By continueShopping=By.xpath("//*[contains(text(),\"Continue Shopping\")]");

    public WebElement getCartButton() {return elementWithWait(cartButton,"clickable");}
    public WebElement getProceedButton() {return elementWithWait(proceedButton,"clickable");}
    public WebElement getBillingNextButton() {return elementWithWait(billingNextButton,"clickable");}
    public WebElement getPlcaeOrderButton() {return elementWithWait(plcaeOrderButton,"clickable");}
    public WebElement getThanksText() {return elementWithWait(thanksText,"clickable");}
    public WebElement getContinueShopping() {return elementWithWait(continueShopping,"clickable");}

    private final By checkoutPrice=By.cssSelector("#opc-sidebar > div.opc-block-summary > table > tbody > tr.grand.totals > td > strong > span");
    private final By purchaseNumber=By.xpath("//*[@class=\"checkout-success\"]/p/a/strong");

    public WebElement geCheckoutPrice() {return elementWithWait(checkoutPrice,"clickable");}
    public WebElement getpurchaseNumber() {return elementWithWait(purchaseNumber,"clickable");}
}
