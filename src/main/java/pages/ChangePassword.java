package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class ChangePassword extends BasePage {
    public ChangePassword(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By changePassbtn = By.xpath("//*[contains(@class,\"action change-password\")]");
    private final By currentPass = By.name("current_password");
    private final By newPass = By.name("password");
    private final By newConfirmPass = By.name("password_confirmation");
    private final By save_btn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");

    public WebElement getchangePassbtn(){return elementWithWait(changePassbtn,"clickable");}
    public WebElement getcurrentPass(){return elementWithWait(currentPass,"visibility");}
    public WebElement getnewPass(){return elementWithWait(newPass,"visibility");}
    public WebElement getnewConfirmPass(){return elementWithWait(newConfirmPass,"visibility");}
    public WebElement getsave_btn(){return elementWithWait(save_btn,"clickable");}

    private final By billingAddress = By.cssSelector("a[data-ui-id='default-billing-edit-link'] span");
    public WebElement getbillingAddress(){return elementWithWait(billingAddress,"clickable");}


}
