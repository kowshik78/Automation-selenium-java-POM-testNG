package tests;

import org.testng.annotations.Test;
import pages.ChangePassword;

import static utils.Constant.*;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void changingPassTest() throws Exception {
        page.getInstance(ChangePassword.class).getchangePassbtn().click();
        page.getInstance(ChangePassword.class).getcurrentPass().sendKeys(currentpassword);
        page.getInstance(ChangePassword.class).getnewPass().sendKeys(newpassword);
        page.getInstance(ChangePassword.class).getnewConfirmPass().sendKeys(newpassword);
        page.getInstance(ChangePassword.class).getsave_btn().click();
    }

}