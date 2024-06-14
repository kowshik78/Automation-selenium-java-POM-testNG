package tests;

import org.testng.annotations.Test;
import pages.ChangePassword;

import static utils.Constant.*;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void changingPassTest() throws Exception {
        page.getInstance(ChangePassword.class).getChangePassBtn().click();
        page.getInstance(ChangePassword.class).getCurrentPass().sendKeys(currentpassword);
        page.getInstance(ChangePassword.class).getNewPass().sendKeys(newpassword);
        page.getInstance(ChangePassword.class).getNewConfirmPass().sendKeys(newpassword);
        page.getInstance(ChangePassword.class).getSaveBtn().click();
    }

}