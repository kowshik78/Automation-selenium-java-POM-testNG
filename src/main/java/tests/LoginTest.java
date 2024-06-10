package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Login;

import java.util.Objects;

import static utils.Constant.loginname;
import static utils.Constant.loginpassword;

public class LoginTest extends BaseTest {
    public boolean status;

    @Test
    public void LoggedinTest() throws Exception {
        status = Objects.equals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/login/");
        if(!status){
            WebElement wl=driver.findElement(By.className("authorization-link"));
            wl.click();
            page.getInstance(Login.class).getName().sendKeys("dd@yopmail.com");
            page.getInstance(Login.class).getPassowrd().sendKeys("Ksl@12345");
            page.getInstance(Login.class).getLogin_btn().click();
        }
        else {
            page.getInstance(Login.class).getName().sendKeys(loginname);
            page.getInstance(Login.class).getPassowrd().sendKeys(loginpassword);
            page.getInstance(Login.class).getLogin_btn().click();

        }
    }
}