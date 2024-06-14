package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import java.io.IOException;
import java.util.List;

public class CompareList extends BasePage{
    public CompareList(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By addCompare= By.xpath("//*[@class=\"product-addto-links\"]//a[2]");
    private final By compareList=By.xpath("//a[text()='comparison list']");
    private final By homeToCompareList=By.xpath("/html/body/div[2]/header/div[2]/ul/li/a");
    private final By logo=By.xpath("//a[@class='logo']");
    private final By printButton=By.xpath("//*[text()='Print This Page']");

    private final By homeTitle=By.cssSelector("div > h1 > span");
    private final By homePrice=By.className("price");
    private final By homeSKU=By.className("value");
    private final By homeDescription=By.cssSelector("#description > div");

    private final By tableRowUpper=By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td");
    private final By compareTitle=By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td/strong");
    private final By comparePrice=By.xpath("//*[contains(@class, 'price-wrapper')]");
    private final By compareSKU=By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[1]/td");
    private final By compareDescription=By.xpath("//*[@id=\"product-comparison\"]/tbody[2]/tr[2]/td");

    public WebElement getAddCompare(){return elementWithWait(addCompare,"clickable");}
    public WebElement getCompareList(){return elementWithWait(compareList,"clickable");}
    public WebElement getHomeToCompareList(){return elementWithWait(homeToCompareList,"clickable");}
    public WebElement getLogo(){return elementWithWait(logo,"clickable");}
    public WebElement getPrintButton(){return elementWithWait(printButton,"clickable");}

    public List<WebElement> getHomeTitle(){return elementsWithWait(homeTitle,"visibility");}
    public List<WebElement> getHomePrice(){return elementsWithWait(homePrice,"visibility");}
    public List<WebElement> getHomeSKU(){return elementsWithWait(homeSKU,"visibility");}
    public List<WebElement> getHomeDescription(){return elementsWithWait(homeDescription,"visibility");}

    public List<WebElement> getTableRowUpper(){return elementsWithWait(tableRowUpper,"clickable");}
    public List<WebElement> getCompareTitle(){return elementsWithWait(compareTitle,"visibility");}
    public List<WebElement> getComparePrice(){return elementsWithWait(comparePrice,"visibility");}
    public List<WebElement> getCompareSKU(){return elementsWithWait(compareSKU,"visibility");}
    public List<WebElement> getCompareDescription(){return elementsWithWait(compareDescription,"visibility");}
}
