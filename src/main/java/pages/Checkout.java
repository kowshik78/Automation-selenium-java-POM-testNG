package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Checkout extends BasePage {
    public Checkout(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By Zip = By.id("postal-code");
    private final By Continue = By.id("continue");

    private final By confirmTitle = By.className("inventory_item_name");
    private final By confirmPrice = By.className("inventory_item_price");
    private final By finish = By.xpath("//*[@id=\"finish\"]");
    private final By confirmMessgae = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private final By confirmMessgae2 = By.className("complete-text");

    public WebElement getFirstName(){return elementWithWait(firstName,"visibility");}
    public WebElement getLastName(){return elementWithWait(lastName,"visibility");}
    public WebElement getZip(){return elementWithWait(Zip,"visibility");}
    public WebElement getContinue(){return elementWithWait(Continue,"clickable");}

    public List<WebElement> getconfirmTitle(){return elementsWithWait(confirmTitle,"clickable");}
    public List<WebElement> getconfirmPrice(){return elementsWithWait(confirmPrice,"clickable");}
    public WebElement getFinish(){return elementWithWait(finish,"clickable");}
    public WebElement getConfirmMEssage(){return elementWithWait(confirmMessgae,"clickable");}
    public WebElement getConfirmMEssage2(){return elementWithWait(confirmMessgae2,"clickable");}


}
