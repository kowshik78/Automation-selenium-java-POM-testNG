package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.ExcelUtil;
import pages.HomePage;
import java.io.IOException;

import static utils.Constant.*;

public class CreateAccountPageTest extends BaseTest {

    @Test(enabled = true)
    public void accountRegisterTest() throws Exception {
        page.getInstance(HomePage.class).getcreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getfirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getlastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getemail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getpassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getconfirmPassword().sendKeys(confirmpassword);
        page.getInstance(CreateAccountPage.class).getSubmit_btn().submit();
        }

        @DataProvider(name = "accountData")
        public Object[][] accountData() throws IOException {
            ExcelUtil excelUtil = new ExcelUtil("C:/Users/kowshik.saha/Desktop/dd.xlsx", "Sheet1");
            int rowCount = excelUtil.getRowCount();
            Object[][] data = new Object[rowCount - 1][5];

            for (int i = 1; i < rowCount; i++) { // Starting from 1 to skip the header row
                data[i - 1] = excelUtil.getRowData(i);
            }

            excelUtil.close();
            return data;
        }

        @Test(dataProvider = "accountData",  enabled = false)
        public void accountRegisterTest1(String firstname, String lastname, String email, String password, String confirmpassword) throws Exception {
            page.getInstance(HomePage.class).getcreateAccountBtn().click();
            page.getInstance(CreateAccountPage.class).getfirstName().sendKeys(firstname);
            page.getInstance(CreateAccountPage.class).getlastName().sendKeys(lastname);
            page.getInstance(CreateAccountPage.class).getemail().sendKeys(email);
            page.getInstance(CreateAccountPage.class).getpassword().sendKeys(password);
            page.getInstance(CreateAccountPage.class).getconfirmPassword().sendKeys(confirmpassword);
            page.getInstance(CreateAccountPage.class).getSubmit_btn().submit();
        }
}