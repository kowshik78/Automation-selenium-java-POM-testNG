package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Login extends BasePage {
    public Login(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By name = By.id("user-name");
    private final By password = By.id("password");
    private final By login_btn = By.id("login-button");

    public WebElement getName(){return elementWithWait(name,"visibility");}
    public WebElement getPassowrd(){return elementWithWait(password,"visibility");}
    public WebElement getLogin_btn(){return elementWithWait(login_btn,"clickable");}

}
