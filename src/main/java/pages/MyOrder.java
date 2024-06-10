package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class MyOrder extends BasePage {
    public MyOrder(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By orderRow = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr");
    private final By orderCell = By.tagName("td");

    public List<WebElement> getOrderRow() {return elementsWithWait(orderRow, "visibility");}
    public List<WebElement> getOrderCell() {return elementsWithWait(orderCell, "visibility");}

}