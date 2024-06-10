package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;

public class Login extends BasePage {
    public Login(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By name = By.name("login[username]");
    private final By password = By.name("login[password]");
    private final By login_btn = By.xpath("//*[@id=\"send2\"]/span");

    public WebElement getName(){return elementWithWait(name,"visibility");}
    public WebElement getPassowrd(){return elementWithWait(password,"visibility");}
    public WebElement getLogin_btn(){return elementWithWait(login_btn,"clickable");}

}
