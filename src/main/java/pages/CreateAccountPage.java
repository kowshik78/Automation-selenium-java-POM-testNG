package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountPage extends BasePage {

    @FindBy(name = "firstname") private WebElement firstName;
    @FindBy(name = "lastname") private WebElement lastName;
    @FindBy(name = "email") private WebElement email;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "password_confirmation") private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button/span") private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='box-content']//p") private WebElement accountName;

    public CreateAccountPage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String printElementInfo() {
        String fullText = accountName.getText();
        String[] parts = fullText.split("\\n");
        return parts[1].trim();

//        String outerHTML = accountName.getAttribute("outerHTML");
//        String emailPattern = "(?<=<br>)[^<]+(?=<br>)";
//        Pattern pattern = Pattern.compile(emailPattern);
//        Matcher matcher = pattern.matcher(outerHTML);
//        if (matcher.find()) {
//            return matcher.group().trim();}
//        else {
//            System.out.println("No email found in the provided HTML.");}
//        return null;
    }

    public WebElement getFirstName() {return elementWithWait(firstName, "visibility");}
    public WebElement getLastName() {return elementWithWait(lastName, "visibility");}
    public WebElement getEmail() {return elementWithWait(email, "visibility");}
    public WebElement getPassword() {return elementWithWait(password, "visibility");}
    public WebElement getConfirmPassword() {return elementWithWait(confirmPassword, "visibility");}
    public WebElement getSubmitBtn() {return elementWithWait(submitBtn, "clickable");}
    public WebElement getAccountName() {return elementWithWait(accountName, "visibility");}
}

