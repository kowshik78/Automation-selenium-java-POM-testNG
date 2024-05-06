package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;

public class CompareList extends BasePage{
    public CompareList(WebDriver driver) throws IOException {
        super(driver);
    }
    private By addCompare= By.xpath("//a[@class='action tocompare']");
    private By compareList=By.xpath("//a[text()='comparison list']");
    private By homeToCompareList=By.xpath("/html/body/div[2]/header/div[2]/ul/li/a");
    private By logo=By.xpath("//a[@class='logo']");
    private By printButton=By.xpath("//*[text()='Print This Page']");

    private By homeTitle=By.cssSelector("div > h1 > span");
    private By homePrice=By.className("price");
    private By homeSKU=By.className("value");
    private By homeDescription=By.cssSelector("#description > div");

    private By compareTitle=By.xpath("//strong/a[text()]");
    private By comparePrice=By.className("price");
    private By compareSKU=By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[1]/td");
    private By compareDescription=By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[2]/td");


    public WebElement getAddCompare(){return elementWithWait(addCompare,"clickable");}
    public WebElement getCompareList(){return elementWithWait(compareList,"clickable");}
    public WebElement getHomeToCompareList(){return elementWithWait(homeToCompareList,"clickable");}
    public WebElement getLogo(){return elementWithWait(logo,"clickable");}
    public WebElement getPrintButton(){return elementWithWait(printButton,"clickable");}

    public WebElement getHomeTitle(){return elementWithWait(homeTitle,"clickable");}
    public WebElement getHomePrice(){return elementWithWait(homePrice,"clickable");}
    public WebElement getHomeSKU(){return elementWithWait(homeSKU,"clickable");}
    public WebElement getHomeDescription(){return elementWithWait(homeDescription,"clickable");}

    public List<WebElement> getCompareTitle(){return elementsWithWait(compareTitle,"clickable");}
    public List<WebElement> getComparePrice(){return elementsWithWait(comparePrice,"clickable");}
    public List<WebElement> getCompareSKU(){return elementsWithWait(compareSKU,"clickable");}
    public List<WebElement> getCompareDescription(){return elementsWithWait(compareDescription,"clickable");}
}
