    package tests;

    import org.openqa.selenium.NoSuchElementException;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.testng.Assert;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
    import org.testng.asserts.SoftAssert;
    import pages.BasePage;
    import pages.RandomDropList;
    import utils.ReadExcelSheet;

    import java.io.IOException;
    import java.util.Map;
    import utils.log;


    public class RandomDropListTest extends BaseTest {
        private static final Logger log = LoggerFactory.getLogger(RandomDropListTest.class);
        public static String s1;
        public static String s2;
        public Map<String, String> actualShippingAddress;
        cartAddTest cAdd = new cartAddTest();

        public void randomWomenChoose() throws Exception {
            Actions actions = new Actions(driver);
            WebElement women= page.getInstance(RandomDropList.class).getHoverWomen();
            actions.moveToElement(women).perform();

            WebElement tops= page.getInstance(RandomDropList.class).getHoverTops();
            actions.moveToElement(tops).perform();
            page.getInstance(RandomDropList.class).getHoverTopsDropdown().click();
            itemChoose();
        }
        public void itemChoose() throws Exception {
            cAdd.addToCart(null);
             performPostSelectionActions();
        }

        public void performPostSelectionActions() throws Exception {
            WebElement cartButton=page.getInstance(RandomDropList.class).getCartButton();takeScreenshot("Hello");
            page.getInstance(RandomDropList.class).jsExecuteScript(cartButton);
            WebElement proceedButton= page.getInstance(RandomDropList.class).getProceedButton();
            page.getInstance(BasePage.class).jsExecuteScript(proceedButton);

            boolean data = false;
            while (!data) {
                try {
                    actualShippingAddress = page.getInstance(RandomDropList.class).printElementInfo();
                    data=true;
                } catch (
                        Exception e) {
                    throw new RuntimeException(e);
                }
            }
            page.getInstance(RandomDropList.class).getRadioButton().click();
            WebElement billingButton=page.getInstance(RandomDropList.class).getBillingNextButton();
            page.getInstance(BasePage.class).jsExecuteScript(billingButton);
            boolean status = false;
            while (!status) {
                try {
                    WebElement w1= page.getInstance(RandomDropList.class).getCheckoutPrice();
                    s1=w1.getText();log.info(s1);
                    status = true;
                } catch (Exception e) {throw new RuntimeException(e);}
            }
            boolean statusQ = false;
            while (!statusQ) {
                try {
                    WebElement placeOrderButton = page.getInstance(RandomDropList.class).getPlaceOrderButton();
                    page.getInstance(BasePage.class).jsExecuteScript(placeOrderButton);
                    statusQ = true;
                } catch (Exception e) {throw new RuntimeException(e);}
            }
            WebElement w2= page.getInstance(RandomDropList.class).getPurchaseNumber();
            s2=w2.getText();log.info(s2);
            ReadExcelSheet.writeEmailToExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, 1, null, s2);

            WebElement continueShoppingButton=page.getInstance(RandomDropList.class).getContinueShopping();
            page.getInstance(BasePage.class).jsExecuteScript(continueShoppingButton);
        }




        @DataProvider(name = "billingData")
        public Object[][] getAccountData() throws IOException {
            String[] requiredColumns = {"menu", "submenu", "subsubmenu", "size"};
            return ReadExcelSheet.getDataFromExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, requiredColumns,2);
        }
        @Test(dataProvider = "billingData")
        public void randomExcelWomenChoose(String menu, String submenu, String subsubmenu,String size) throws Exception {
            log.info("STARTED");
            boolean status = false;
            while (!status) {
                try {
                    Actions actions = new Actions(driver);
                    WebElement women = page.getInstance(RandomDropList.class).getMenuElement(menu);
                    actions.moveToElement(women).perform();

                    WebElement tops = page.getInstance(RandomDropList.class).getSubmenuElement(submenu);
                    actions.moveToElement(tops).perform();
                    page.getInstance(RandomDropList.class).getSubsubmenuElement(subsubmenu).click();
                    status=true;
                } catch (NoSuchElementException e) {throw new RuntimeException(e);}
            }
                itemChoose(size);
        }
        public void itemChoose(String size) throws Exception {
            cAdd.addToCart(size);
            performPostSelectionActions();
            Map<String, String> actualBillingAddress = ChangeBillingAddressTest.actualAddress; System.out.println(actualShippingAddress+"__"+actualBillingAddress);
            SoftAssert softAssert = new SoftAssert();
            for (String key : actualShippingAddress.keySet()) {
                log.info(key);
                log.info(actualBillingAddress.get(key));
                softAssert.assertEquals(actualShippingAddress.get(key), actualBillingAddress.get(key), key + " does not match!");
            }
            softAssert.assertAll();
        }

    }