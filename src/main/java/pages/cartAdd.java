package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class cartAdd extends BasePage {

    @FindBy(xpath = "//*[@class=\"swatch-option text\"]") private List<WebElement> size;
    @FindBy(xpath = "//*[@class=\"swatch-option color\"]") private List<WebElement> color;
    @FindBy(id = "product-addtocart-button") private WebElement addToCartBtn;
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a") private WebElement cartButton;
    @FindBy(xpath = "//*[@title='Remove item']") private List<WebElement> productDelete;
    @FindBy(xpath = "/html/body/div[4]/aside[2]/div[2]/footer/button[2]") private WebElement alertConfirm;

    public cartAdd(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSize(){return elementsWithWait(size, "clickable");}
    public List<WebElement> getColor(){return elementsWithWait(color, "clickable");}
    public WebElement getAddToCartBtn(){return elementWithWait(addToCartBtn, "clickable");}
    public WebElement getCartButton(){return elementWithWait(cartButton, "clickable");}
    public List<WebElement> getProductDelete(){return elementsWithWait(productDelete, "clickable");}
    public WebElement getAlertConfirm(){return elementWithWait(alertConfirm, "clickable");}
}
