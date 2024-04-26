package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    private By createAccountBtn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private By cardSelector = By.className("product-image-photo");
    private By linkSelector = By.tagName("a");

    public WebElement getcreateAccountBtn(){return elementWithWait(createAccountBtn,"clickable");}
    public WebElement getCardSelector() { return elementWithWait(cardSelector,"clickable"); }
    public List<WebElement> getLinkSelector() { return elementsWithWait(linkSelector,"clickable"); }

}
