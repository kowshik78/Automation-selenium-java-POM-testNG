package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class MyOrder extends BasePage {

    @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr") private List<WebElement> orderRow;
    @FindBy(tagName = "td") private List<WebElement> orderCell;

    public MyOrder(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getOrderRow() {return elementsWithWait(orderRow, "visibility");}
    public List<WebElement> getOrderCell() {return elementsWithWait(orderCell, "visibility");}
}
