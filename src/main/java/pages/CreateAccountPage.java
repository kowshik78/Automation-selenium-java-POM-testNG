package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) throws IOException {
        super(driver);
    }

    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By email = By.name("email");
    private By password = By.name("password");
    private By confirmPassword = By.name("password_confirmation");
    private By Submit_btn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");


    public WebElement getfirstName(){return elementWithWait(firstName,"visibility");}
    public WebElement getlastName(){return elementWithWait(lastName,"visibility");}
    public WebElement getemail(){return elementWithWait(email,"visibility");}
    public WebElement getpassword(){return elementWithWait(password,"visibility");}
    public WebElement getconfirmPassword(){return elementWithWait(confirmPassword,"visibility");}
    public WebElement getSubmit_btn(){return elementWithWait(Submit_btn,"clickable");}

}
