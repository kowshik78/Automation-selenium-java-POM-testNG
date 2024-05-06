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

    private By size = By.cssSelector("div.swatch-option.text");
    private By color = By.cssSelector("div.swatch-option.color");
    private By submitBtn= By.id("product-addtocart-button");
    private By cartButton= By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By productDelete= By.xpath("//*[@title='Remove item']");
    private By alertConfirm= By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[2]");


    public List<WebElement> getSize(){return elementsWithWait(size,"visibility");}
    public List<WebElement> getColor(){return elementsWithWait(color,"visibility");}
    public WebElement getSubmitBtn(){return elementWithWait(submitBtn,"visibility");}
    public WebElement getcartButton(){return elementWithWait(cartButton,"clickable");}
    public List<WebElement> getproductdelete(){return elementsWithWait(productDelete,"clickable");}
    public WebElement getAlertConfirm(){return elementWithWait(alertConfirm,"clickable");}

}
