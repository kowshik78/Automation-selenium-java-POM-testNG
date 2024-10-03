package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CreateAccountPage;
import pages.HomePage;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import utils.ReadExcelSheet;
import utils.log;

import static utils.Constant.*;
public class CreateAccountPageTest extends BaseTest {

    public void accountRegisterTest() throws Exception {
        page.getInstance(HomePage.class).getCreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getFirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getLastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getEmail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getConfirmPassword().sendKeys(confirmpassword);
        page.getInstance(CreateAccountPage.class).getSubmitBtn().submit();
    }



    @DataProvider(name = "accountData")
    public Object[][] getAccountData() throws IOException {
        String[] requiredColumns = {"firstname", "lastname", "password"};
        return ReadExcelSheet.getDataFromExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, requiredColumns, null);
    }
    @Test(dataProvider = "accountData")
    public void ExcelAccountRegisterTest(String firstname, String lastname, String password) throws Exception {
        String email = randomGenerator();
        int currentRow = getCurrentRow(firstname);
        ReadExcelSheet.writeEmailToExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, currentRow, email, null);

        page.getInstance(HomePage.class).getCreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getFirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getLastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getEmail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getConfirmPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getSubmitBtn().submit();

        String e= page.getInstance(CreateAccountPage.class).printElementInfo(); System.out.println(e);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(e, email, "Email does not match!");
        softAssert.assertAll();
        log.info("String"+e);
        log.info("String2"+email);
        driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
}

    protected int getCurrentRow(String firstName) throws IOException {
        String[] requiredColumns = {"firstname"};
        Object[][] data = ReadExcelSheet.getDataFromExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, requiredColumns, null);

        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(firstName)) {
                return i + 1;
            }
        }
        return -1;
    }
}
