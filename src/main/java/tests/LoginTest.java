package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import utils.ReadExcelSheet;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

import static utils.Constant.loginname;
import static utils.Constant.loginpassword;

public class LoginTest extends BaseTest {
    public static boolean status=false;

    public void LoggedinTest() throws Exception {
        status = Objects.equals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/login/");
        if(!status){
            WebElement wl=driver.findElement(By.className("authorization-link"));
            wl.click();
            page.getInstance(Login.class).getName().sendKeys("dd@yopmail.com");
            page.getInstance(Login.class).getPassword().sendKeys("Ksl@12345");
            page.getInstance(Login.class).getLoginBtn().click();
        }
        else {
            page.getInstance(Login.class).getName().sendKeys(loginname);
            page.getInstance(Login.class).getPassword().sendKeys(loginpassword);
            page.getInstance(Login.class).getLoginBtn().click();

        }
    }


    @DataProvider(name = "loginData")
    public Object[][] getAccountData() throws IOException {
        String[] requiredColumns = {"email", "password"};
        return ReadExcelSheet.getDataFromExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, requiredColumns,2);
    }

    @Test(dataProvider = "loginData")
    public void ExcelLoginTest(String email, String password) throws Exception {
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            page.getInstance(Login.class).getName().sendKeys(email);
            page.getInstance(Login.class).getPassword().sendKeys(password);
            page.getInstance(Login.class).getLoginBtn().click();
    }

}