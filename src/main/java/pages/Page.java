package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public abstract class Page {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    public Page(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    protected abstract String getPageTitle();
    protected abstract void waitForPageTitle(String title);
    protected abstract void sleep(int milliseconds) throws InterruptedException;
    protected void scrollDown(){ }
    protected abstract void jsExecuteScript(WebElement el);

    protected abstract WebElement getElementBy(By locator);
    protected abstract WebElement getElementBy(WebElement parent, By locator);
    protected abstract List<WebElement> getElementsBy(By locator);
    protected abstract List<WebElement> getElementsBy(WebElement parent, By locator);

    protected abstract WebElement elementWithWait(By element, String type) ;
    public abstract List<WebElement> elementsWithWait(By element, String type) ;

    public abstract WebElement elementWithWait(WebElement element, String type);
    public abstract List<WebElement> elementsWithWait(List<WebElement> elements, String type);

    protected abstract void waitForElementPresent(By locator);
    protected abstract int getSizeForCommonElements(By locator);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception ignored) { }
        return null;
    }

}
