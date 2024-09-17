package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.*;

import utils.ReadExcelSheet;
import static utils.Constant.*;

public class CreateAccountPageTest extends BaseTest {
    public Map<String, String> emailMap = new HashMap<>();
    private static final String filePath = "resources/excel.xlsx";
    private static final String sheetName = "Sheet1";

/*    public void accountRegisterTest() throws Exception {
        page.getInstance(HomePage.class).getCreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getFirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getLastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getEmail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getConfirmPassword().sendKeys(confirmpassword);
        page.getInstance(CreateAccountPage.class).getSubmitBtn().submit();
    }*/

    @DataProvider(name = "accountData")
    public Object[][] getAccountData() throws IOException {
        return ReadExcelSheet.getDataFromExcel(filePath, sheetName);
    }

    @Test(dataProvider = "accountData")
    public void accountRegisterTest(String firstname, String lastname, String password) throws Exception {
        String email = randomGenerator(); //emailMap.put(firstname, email);
        int currentRow = getCurrentRow(firstname);
        ReadExcelSheet.writeEmailToExcel(filePath, sheetName, currentRow, email);

        page.getInstance(HomePage.class).getCreateAccountBtn().click();
        page.getInstance(CreateAccountPage.class).getFirstName().sendKeys(firstname);
        page.getInstance(CreateAccountPage.class).getLastName().sendKeys(lastname);
        page.getInstance(CreateAccountPage.class).getEmail().sendKeys(email);
        page.getInstance(CreateAccountPage.class).getPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getConfirmPassword().sendKeys(password);
        page.getInstance(CreateAccountPage.class).getSubmitBtn().submit();

        driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
        //page.getInstance(CreateAccountPage.class).getPromptToLogout().click();
        //page.getInstance(CreateAccountPage.class).getLogoutToSignup().click();
        //WebElement e= page.getInstance(CreateAccountPage.class).getAccountName();
        //System.out.println(email+"  "+ page.getInstance(CreateAccountPage.class).getAccountName());
        //Assert.assertEquals(email, e.getText());
        //driver.close();
}

    private int getCurrentRow(String firstName) throws IOException {
        Object[][] data = ReadExcelSheet.getDataFromExcel(CreateAccountPageTest.filePath, CreateAccountPageTest.sheetName);

        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(firstName)) {
                return i + 1;
            }
        }
        return -1;
    }
}
