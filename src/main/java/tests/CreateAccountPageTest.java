package tests;

import org.testng.annotations.Test;
import pages.CreateAccountPage;

import static utils.Constant.*;

public class CreateAccountPageTest extends BaseTest {

    @Test
    public void accountRegisterTest() throws Exception {
        page.getInstance(CreateAccountPage.class).getfirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getlastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getemail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getpassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getconfirmPassword().sendKeys(confirmpassword);
        page.getInstance(CreateAccountPage.class).getSubmit_btn().submit();

    }
}
