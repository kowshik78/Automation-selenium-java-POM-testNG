package tests;
import org.testng.annotations.Test;
import pages.SubcriberPage;
import java.util.*;

import static utils.Constant.*;


public class SubcriberTest extends BaseTest {

    @Test
    public void Subscribe() throws Exception {
        Set<String> windows = driver.getWindowHandles();
        String parent = driver.getWindowHandle();

        for (String handler : windows) {
            if (handler.equals(parent) == false) {
                driver.switchTo().window(handler);

                SubcriberPage subcriberPage = page.getInstance(SubcriberPage.class);
                subcriberPage.getEmail().sendKeys(email);
                subcriberPage.getFirstName().sendKeys(firstname);
                subcriberPage.getLastName().sendKeys(lastname);
                subcriberPage.getCompanyName().sendKeys(email + firstname + lastname);
                subcriberPage.getPosition().sendKeys(zip);
                subcriberPage.getSubscribeBtn().click();

                driver.switchTo().window(parent);
            }
        }
    }
}