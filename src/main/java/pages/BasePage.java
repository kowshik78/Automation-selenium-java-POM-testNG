package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) throws IOException {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleIs(title));
        } catch(Exception e) {
            System.out.println("some exception occurred while waiting for "+title);
        }
    }

    @Override
    public void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    @Override
    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1000);");
    }

    @Override
    public WebElement getElementBy(By locator) {
        WebElement element = null;
        element = driver.findElement(locator);
        return element;
    }

    @Override
    public WebElement getElementBy(WebElement parent, By locator) {
        WebElement element = null;
        element = parent.findElement(locator);
        return element;
    }

    @Override
    public List<WebElement> getElementsBy(By locator) {
        List<WebElement> list = null;
        list = driver.findElements(locator);
        return list;
    }

    @Override
    protected List<WebElement> getElementsBy(WebElement parent, By locator) {
        List<WebElement> list = null;
        list = parent.findElements(locator);
        return list;
    }

    @Override
    public WebElement elementWithWait(By element, String type){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-progress-bar")));
        if(type.equals("presence")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        else if(type.equals("visibility")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        else if(type.equals("clickable")) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));
        try {
            return getElementBy(element);
        }catch (StaleElementReferenceException e){
            return getElementBy(element);
        }
    }

    @Override
    public List<WebElement> elementsWithWait(By element, String type){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".page-loader-container")));
        if(type.equals("presence")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        else if(type.equals("visibility")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        else if(type.equals("clickable")) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));
        try {
            return getElementsBy(element);
        }catch (StaleElementReferenceException e){
            return getElementsBy(element);
        }
    }

    @Override
    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(Exception e) {
            System.out.println("some exception occurred while waiting for "+locator.toString());
        }
    }

    @Override
    public int getSizeForCommonElements(By locator){
        if(!driver.getCurrentUrl().contains("my-chain-")){
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        else {
            return 0;
        }
        return 0;
    }

}