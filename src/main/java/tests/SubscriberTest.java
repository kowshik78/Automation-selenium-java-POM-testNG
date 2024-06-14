package tests;
import org.testng.annotations.Test;
import pages.SubscriberPage;

import static utils.Constant.*;


public class SubscriberTest extends BaseTest {

    @Test
    public void Subscribe() throws Exception {
        //Set<String> windows = driver.getWindowHandles();
        String parent = driver.getWindowHandle();

        for (String handler : driver.getWindowHandles()) {
            if (!handler.equals(parent)) {
                driver.switchTo().window(handler);

                SubscriberPage subscriberPage = page.getInstance(SubscriberPage.class);
                subscriberPage.getEmail().sendKeys(email);
                subscriberPage.getFirstName().sendKeys(firstname);
                subscriberPage.getLastName().sendKeys(lastname);
                subscriberPage.getCompanyName().sendKeys(email + firstname + lastname);
                subscriberPage.getPosition().sendKeys(zip);
                subscriberPage.getSubscribeBtn().click();
                driver.close();

                driver.switchTo().window(parent);
            }
        }
    }
}