package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChangePassword extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'action change-password')]") private WebElement changePassBtn;
    @FindBy(name = "current_password") private WebElement currentPass;
    @FindBy(name = "password") private WebElement newPass;
    @FindBy(name = "password_confirmation") private WebElement newConfirmPass;
    @FindBy(xpath = "//*[@id='form-validate']/div/div[1]/button/span") private WebElement saveBtn;

    @FindBy(css = "a[data-ui-id='default-billing-edit-link'] span") private WebElement billingAddress;

    public ChangePassword(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getChangePassBtn() {return elementWithWait(changePassBtn, "clickable");}
    public WebElement getCurrentPass() {return elementWithWait(currentPass, "visibility");}
    public WebElement getNewPass() {return elementWithWait(newPass, "visibility");}
    public WebElement getNewConfirmPass() {return elementWithWait(newConfirmPass, "visibility");}
    public WebElement getSaveBtn() {return elementWithWait(saveBtn, "clickable");}
    public WebElement getBillingAddress() {return elementWithWait(billingAddress, "clickable");}
}
