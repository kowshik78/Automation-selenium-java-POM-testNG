package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class cartAdd extends BasePage {
    public cartAdd(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By product = By.className("inventory_item_name");
    private final By cart = By.name("add-to-cart");
    private final By name = By.xpath("//*[@id=\"inventory_item_container\"]//div[2]/div[1]");
    private final By price = By.className("inventory_details_price");
    private final By cartPage = By.className("shopping_cart_link");
    private final By compareTitle=By.className("inventory_item_name");
    private final By comparePrice=By.className("inventory_item_price");
    private final By checkout=By.id("checkout");

    public List<WebElement> getProduct(){return elementsWithWait(product,"clickable");}
    public WebElement getCart(){return elementWithWait(cart,"clickable");}
    public List<WebElement> getName(){return elementsWithWait(name,"clickable");}
    public List<WebElement> getPrice(){return elementsWithWait(price,"clickable");}
    public WebElement getCartPage(){return elementWithWait(cartPage,"clickable");}
    public List<WebElement> getCompareTitle(){return elementsWithWait(compareTitle,"clickable");}
    public List<WebElement> getComparePrice(){return elementsWithWait(comparePrice,"clickable");}
    public WebElement getCheckout(){return elementWithWait(checkout,"clickable");}

}
