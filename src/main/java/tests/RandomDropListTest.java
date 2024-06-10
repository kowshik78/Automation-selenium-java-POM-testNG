    package tests;

    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.testng.annotations.Test;
    import pages.BasePage;
    import pages.RandomDropList;
    public class RandomDropListTest extends BaseTest {
        public static String s1;
        public static String s2;
        cartAddTest cAdd = new cartAddTest();
        @Test
        public void randomWomenChoose() throws Exception {
            Actions actions = new Actions(driver);
            WebElement women= page.getInstance(RandomDropList.class).getHoverWomen();
            actions.moveToElement(women).perform();takeScreenshot("Hello");

            WebElement tops= page.getInstance(RandomDropList.class).getHoverTops();
            actions.moveToElement(tops).perform();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).getHoverTopsDropdown().click();takeScreenshot("Hello");
            itemChoose();

            /*actions.moveToElement(women).perform();takeScreenshot("Hello");
            WebElement bottoms= page.getInstance(RandomDropList.class).getHoverBottom();
            actions.moveToElement(bottoms).perform();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).getHoverBottomsDropdown().click();takeScreenshot("Hello");
            itemChoose();*/
        }
        public void itemChoose() throws Exception {
            cAdd.addToCart();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).getCartButton().click();takeScreenshot("Hello");
            Thread.sleep(10000);
            WebElement proceedButton= page.getInstance(RandomDropList.class).getProceedButton();
            page.getInstance(BasePage.class).jsExecuteScript(proceedButton);

            page.getInstance(RandomDropList.class).getBillingNextButton().click();
            Thread.sleep(10000);
            takeScreenshot("Hello");
            WebElement w1= page.getInstance(RandomDropList.class).geCheckoutPrice(); s1=w1.getText();
            System.out.println(s1);

            Thread.sleep(10000);
            page.getInstance(RandomDropList.class).getPlcaeOrderButton().click();takeScreenshot("Hello");
            Thread.sleep(10000);
            WebElement w2= page.getInstance(RandomDropList.class).getpurchaseNumber(); s2=w2.getText();
            System.out.println(s2);
            page.getInstance(RandomDropList.class).getContinueShopping().click();
        }
    }