package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;

public class SubcriberPage extends BasePage {
    public SubcriberPage(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By email = By.xpath("//*[@id=\"mce-EMAIL\"]");
    private final By firstName = By.id("mce-FNAME");
    private final By lastName = By.id("mce-LNAME");
    private final By companyName = By.id("mce-COMPANY");
    private final By position = By.id("mce-POSITION");
    private final By subscribe_btn = By.id("mc-embedded-subscribe");

    public WebElement getEmail(){return elementWithWait(email,"visibility");}
    public WebElement getFirstName(){return elementWithWait(firstName,"visibility");}
    public WebElement getLastName(){return elementWithWait(lastName,"visibility");}
    public WebElement getCompanyName(){return elementWithWait(companyName,"visibility");}
    public WebElement getPosition(){return elementWithWait(position,"visibility");}
    public WebElement getSubscribeBtn(){return elementWithWait(subscribe_btn,"visibility");}
}
