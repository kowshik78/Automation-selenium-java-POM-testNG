package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    private By createAccountBtn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    public WebElement getcreateAccountBtn(){return elementWithWait(createAccountBtn,"clickable");}

    private By popupClose = By.cssSelector("img[title='Close']");
    private By joinTrainingLink = By.linkText("Join Training");
    private By tryTestCaseStudioLink = By.partialLinkText("Try TestCa");
    public WebElement getPopupCloseBtn(){return elementWithWait(popupClose,"clickable");}
}
