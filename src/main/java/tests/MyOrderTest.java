package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyOrder;

import java.util.List;

public class MyOrderTest extends BaseTest{
    @Test
    public void myOrderTest() throws Exception {

        driver.get("https://magento.softwaretestingboard.com/sales/order/history/");
        List<WebElement> rows=page.getInstance(MyOrder.class).getOrderRow();
        for(WebElement row:rows){

            List<WebElement> cells = page.getInstance(MyOrder.class).getOrderCell();
            String Order=cells.get(0).getText();
            String OrderTotal=cells.get(3).getText();

            System.out.println("Order: " + Order+"__"+"OrderTotal: " + OrderTotal);
            System.out.println("s1: " + RandomDropListTest.s1+"__"+"s2: " + RandomDropListTest.s2);

            if(OrderTotal.equals(RandomDropListTest.s1)&&Order.equals(RandomDropListTest.s2)){
                Assert.assertEquals(OrderTotal,RandomDropListTest.s1,"Order Amount does not match");
                Assert.assertEquals(Order,RandomDropListTest.s2,"Order Number does not match");
                break;
            }
            else {
                Assert.fail("Order dont exist");
            }
        }
    }

}
