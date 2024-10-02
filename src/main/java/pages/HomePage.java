package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a") private WebElement createAccountBtn;
    @FindBy(xpath = "//img[@class=\"product-image-photo\"]") private List<WebElement> cardSelector;
    @FindBy(tagName = "a") private List<WebElement> linkSelector;
    @FindBy(linkText = "Subscribe") private WebElement subscriberSelector;

    public HomePage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateAccountBtn() {return elementWithWait(createAccountBtn, "clickable");}
    public List<WebElement> getCardSelector() {return elementsWithWait(cardSelector, "clickable");}
    public List<WebElement> getLinkSelector() {return elementsWithWait(linkSelector, "clickable");}
    public WebElement getSubscriberSelector() {return elementWithWait(subscriberSelector, "clickable");}
}
