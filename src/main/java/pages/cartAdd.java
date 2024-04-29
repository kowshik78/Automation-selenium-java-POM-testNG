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

    public List<WebElement> getSize(){return elementsWithWait(size,"visibility");}
    public List<WebElement> getColor(){return elementsWithWait(color,"visibility");}
    public WebElement getSubmitBtn(){return elementWithWait(submitBtn,"visibility");}

}
