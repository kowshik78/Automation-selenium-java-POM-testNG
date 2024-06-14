package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CompareList extends BasePage {

    @FindBy(xpath = "//*[@class=\"product-addto-links\"]//a[2]") private WebElement addCompare;
    @FindBy(xpath = "//a[text()='comparison list']") private WebElement compareList;
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/ul/li/a") private WebElement homeToCompareList;
    @FindBy(xpath = "//a[@class='logo']") private WebElement logo;
    @FindBy(xpath = "//*[text()='Print This Page']") private WebElement printButton;

    @FindBy(css = "div > h1 > span") private List<WebElement> homeTitle;
    @FindBy(className = "price") private List<WebElement> homePrice;
    @FindBy(className = "value") private List<WebElement> homeSKU;
    @FindBy(css = "#description > div") private List<WebElement> homeDescription;

    @FindBy(xpath = "//*[@id=\"product-comparison\"]/tbody[1]/tr/td") private List<WebElement> tableRowUpper;
    @FindBy(xpath = "//*[@id=\"product-comparison\"]/tbody[1]/tr/td/strong") private List<WebElement> compareTitle;
    @FindBy(xpath = "//*[contains(@class, 'price-wrapper')]") private List<WebElement> comparePrice;
    @FindBy(xpath = "//*[@id=\"product-comparison\"]/tbody[2]/tr[1]/td") private List<WebElement> compareSKU;
    @FindBy(xpath = "//*[@id=\"product-comparison\"]/tbody[2]/tr[2]/td") private List<WebElement> compareDescription;

    public CompareList(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddCompare() {return elementWithWait(addCompare, "clickable");}
    public WebElement getCompareList() {return elementWithWait(compareList, "clickable");}
    public WebElement getHomeToCompareList() {return elementWithWait(homeToCompareList, "clickable");}
    public WebElement getLogo() {return elementWithWait(logo, "clickable");}
    public WebElement getPrintButton() {return elementWithWait(printButton, "clickable");}

    public List<WebElement> getHomeTitle() {return elementsWithWait(homeTitle, "visibility");}
    public List<WebElement> getHomePrice() {return elementsWithWait(homePrice, "visibility");}
    public List<WebElement> getHomeSKU() {return elementsWithWait(homeSKU, "visibility");}
    public List<WebElement> getHomeDescription() {return elementsWithWait(homeDescription, "visibility");}

    public List<WebElement> getTableRowUpper() {return elementsWithWait(tableRowUpper, "clickable");}
    public List<WebElement> getCompareTitle() {return elementsWithWait(compareTitle, "visibility");}
    public List<WebElement> getComparePrice() {return elementsWithWait(comparePrice, "visibility");}
    public List<WebElement> getCompareSKU() {return elementsWithWait(compareSKU, "visibility");}
    public List<WebElement> getCompareDescription() {return elementsWithWait(compareDescription, "visibility");}
}
