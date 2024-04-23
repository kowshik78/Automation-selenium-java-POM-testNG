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


    public WebElement getfirstName(){return elementWithWait(firstName,"presence");}
    public WebElement getlastName(){return elementWithWait(lastName,"presence");}
    public WebElement getemail(){return elementWithWait(email,"presence");}
    public WebElement getpassword(){return elementWithWait(password,"presence");}
    public WebElement getconfirmPassword(){return elementWithWait(confirmPassword,"presence");}
    public WebElement getSubmit_btn(){return elementWithWait(Submit_btn,"clickable");}

}
