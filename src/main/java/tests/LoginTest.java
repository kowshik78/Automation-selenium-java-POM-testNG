package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Login;

import java.util.Objects;

import static utils.Constant.*;

public class LoginTest extends BaseTest {
    public static boolean status;

    @Test
    public void LoggedinTest() throws Exception {
        if(Objects.equals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/login/")) {
            status = true;
        }
        else { status = false;}
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