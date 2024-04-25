package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class ChangePassword extends BasePage {
    public ChangePassword(WebDriver driver) throws IOException {
        super(driver);
    }

    private By changePassbtn = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div/div[2]/a[2]");
    private By currentPass = By.name("current_password");
    private By newPass = By.name("password");
    private By newConfirmPass = By.name("password_confirmation");
    private By save_btn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");

    public WebElement getchangePassbtn(){return elementWithWait(changePassbtn,"clickable");}
    public WebElement getcurrentPass(){return elementWithWait(currentPass,"visibility");}
    public WebElement getnewPass(){return elementWithWait(newPass,"visibility");}
    public WebElement getnewConfirmPass(){return elementWithWait(newConfirmPass,"visibility");}
    public WebElement getsave_btn(){return elementWithWait(save_btn,"clickable");}

    private By billingAddress = By.cssSelector("a[data-ui-id='default-billing-edit-link'] span");
    public WebElement getbillingAddress(){return elementWithWait(billingAddress,"clickable");}


}
