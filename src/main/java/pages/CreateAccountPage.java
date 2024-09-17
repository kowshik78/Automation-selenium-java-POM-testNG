package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreateAccountPage extends BasePage {

    @FindBy(name = "firstname") private WebElement firstName;
    @FindBy(name = "lastname") private WebElement lastName;
    @FindBy(name = "email") private WebElement email;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "password_confirmation") private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button/span") private WebElement submitBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p/text()[2]") private WebElement accountName;
    //@FindBy(xpath = "//header/div[1]/div/ul/li[2]/div/ul/li[3]/a") private WebElement logoutToSignup;
    //@FindBy(xpath = "(//*[@data-action=\"customer-menu-toggle\"])[1]") private WebElement promptToLogout;

    public CreateAccountPage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstName() {return elementWithWait(firstName, "visibility");}
    public WebElement getLastName() {return elementWithWait(lastName, "visibility");}
    public WebElement getEmail() {return elementWithWait(email, "visibility");}
    public WebElement getPassword() {return elementWithWait(password, "visibility");}
    public WebElement getConfirmPassword() {return elementWithWait(confirmPassword, "visibility");}
    public WebElement getSubmitBtn() {return elementWithWait(submitBtn, "clickable");}
    public WebElement getAccountName() {return elementWithWait(accountName, "visibility");}
    //public WebElement getLogoutToSignup() {return elementWithWait(logoutToSignup, "clickable");}
    //public WebElement getPromptToLogout() {return elementWithWait(promptToLogout, "clickable");}
}

