package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By createAccountBtn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private final By cardSelector = By.xpath("//*[@class=\"product-item-info\"]/a");
    private final By linkSelector = By.tagName("a");
    private final By subscriberSelector = By.linkText("Subscribe");

    public WebElement getcreateAccountBtn(){return elementWithWait(createAccountBtn,"clickable");}
    public List<WebElement> getCardSelector() { return elementsWithWait(cardSelector,"clickable"); }
    public List<WebElement> getLinkSelector() { return elementsWithWait(linkSelector,"clickable"); }
    public WebElement getSubscriberSelector() { return elementWithWait(subscriberSelector,"clickable"); }

}
