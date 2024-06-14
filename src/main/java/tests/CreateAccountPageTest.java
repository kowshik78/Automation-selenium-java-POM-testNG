package tests;

import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;

import static utils.Constant.*;

public class CreateAccountPageTest extends BaseTest {

    @Test
    public void accountRegisterTest() throws Exception {
        page.getInstance(HomePage.class).getCreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getFirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getLastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getEmail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getConfirmPassword().sendKeys(confirmpassword);
        page.getInstance(CreateAccountPage.class).getSubmitBtn().submit();

    }
}
