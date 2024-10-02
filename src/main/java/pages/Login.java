package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Login extends BasePage {

    @FindBy(name = "login[username]") private WebElement name;
    @FindBy(name = "login[password]") private WebElement password;
    @FindBy(xpath = "//*[@id=\"send2\"]/span") private WebElement loginBtn;

    public Login(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getName() {return elementWithWait(name, "visibility");}
    public WebElement getPassword() {return elementWithWait(password, "visibility");}
    public WebElement getLoginBtn() {return elementWithWait(loginBtn, "clickable");}

}
