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
            actions.moveToElement(women).perform();

            WebElement tops= page.getInstance(RandomDropList.class).getHoverTops();
            actions.moveToElement(tops).perform();
            page.getInstance(RandomDropList.class).getHoverTopsDropdown().click();
            itemChoose();

            /*actions.moveToElement(women).perform();takeScreenshot("Hello");
            WebElement bottoms= page.getInstance(RandomDropList.class).getHoverBottom();
            actions.moveToElement(bottoms).perform();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).getHoverBottomsDropdown().click();takeScreenshot("Hello");
            itemChoose();*/
        }
        public void itemChoose() throws Exception {
            cAdd.addToCart();
            WebElement cartButton=page.getInstance(RandomDropList.class).getCartButton();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).jsExecuteScript(cartButton);
            WebElement proceedButton= page.getInstance(RandomDropList.class).getProceedButton();
            page.getInstance(BasePage.class).jsExecuteScript(proceedButton);

            WebElement billingButton=page.getInstance(RandomDropList.class).getBillingNextButton();takeScreenshot("Hello");
            page.getInstance(BasePage.class).jsExecuteScript(billingButton);
            WebElement w1= page.getInstance(RandomDropList.class).geCheckoutPrice();s1=w1.getText();
            System.out.println(s1);

            WebElement placeOrderButton=page.getInstance(RandomDropList.class).getPlcaeOrderButton();takeScreenshot("Hello");
            page.getInstance(BasePage.class).jsExecuteScript(placeOrderButton);
            WebElement w2= page.getInstance(RandomDropList.class).getpurchaseNumber();s2=w2.getText();
            System.out.println(s2);

            WebElement continueShoppingButton=page.getInstance(RandomDropList.class).getContinueShopping();
            page.getInstance(BasePage.class).jsExecuteScript(continueShoppingButton);
        }
    }