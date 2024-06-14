package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SubscriberPage extends BasePage {

    public SubscriberPage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='mce-EMAIL']") private WebElement email;
    @FindBy(id = "mce-FNAME") private WebElement firstName;
    @FindBy(id = "mce-LNAME") private WebElement lastName;
    @FindBy(id = "mce-COMPANY") private WebElement companyName;
    @FindBy(id = "mce-POSITION") private WebElement position;
    @FindBy(id = "mc-embedded-subscribe") private WebElement subscribeBtn;

    public WebElement getEmail() {return elementWithWait(email, "visibility");}
    public WebElement getFirstName() {return elementWithWait(firstName, "visibility");}
    public WebElement getLastName() {return elementWithWait(lastName, "visibility");}
    public WebElement getCompanyName() {return elementWithWait(companyName, "visibility");}
    public WebElement getPosition() {return elementWithWait(position, "visibility");}
    public WebElement getSubscribeBtn() {return elementWithWait(subscribeBtn, "visibility");}
}
