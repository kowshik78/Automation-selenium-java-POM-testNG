package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ChangeBillingAddress;
import pages.ChangePassword;
import pages.CreateAccountPage;
import utils.ReadExcelSheet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;

import static utils.Constant.*;

public class ChangeBillingAddressTest extends BaseTest {
    public static Map<String, String> actualAddress;

    public void changeDefaultBillingAddressTest() throws Exception {
        page.getInstance(ChangePassword.class).getBillingAddress().click();
        page.getInstance(ChangeBillingAddress.class).getStreet1().sendKeys(street1);
        page.getInstance(ChangeBillingAddress.class).getCity().sendKeys(city);
        WebElement RegionDropdown = page.getInstance(ChangeBillingAddress.class).getRegion();
        WebElementListHandle(RegionDropdown);

        page.getInstance(ChangeBillingAddress.class).getZip().sendKeys(zip);
        WebElement countryDropdown = page.getInstance(ChangeBillingAddress.class).getCountry();
        WebElementListHandle(countryDropdown);

        page.getInstance(ChangeBillingAddress.class).getTelephone().sendKeys(telephone);
        page.getInstance(ChangeBillingAddress.class).getSaveButton().click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
    }

    private void WebElementListHandle(WebElement drop) throws NoSuchElementException {
        try {
            Select select = new Select(drop);
            List<WebElement> Types = select.getOptions();
            int size = Types.size();
            Random random = new Random();
            int randomIndex = random.nextInt(size);
            Types.get(randomIndex).click();
        }
        catch (TimeoutException ignored){}
    }



    @DataProvider(name = "billingData")
    public Object[][] getAccountData() throws IOException {
        String[] requiredColumns = {"street1", "city", "state", "zip", "country", "telephone"};
        return ReadExcelSheet.getDataFromExcel(ReadExcelSheet.filePath, ReadExcelSheet.sheetName, requiredColumns,2);
    }

    @Test(dataProvider = "billingData")
    public void ExcelChangeDefaultBillingAddressTest(String street1, String city, String state, String zip, String country, String telephone) throws Exception {

        Map<String, String> expectedAddress = new HashMap<>();
        expectedAddress.put("street1", street1);expectedAddress.put("city", city);
        expectedAddress.put("state", state);expectedAddress.put("zipcode", zip);
        expectedAddress.put("country", country);expectedAddress.put("telephone", telephone);

        page.getInstance(ChangePassword.class).getBillingAddress().click();
        page.getInstance(ChangeBillingAddress.class).getStreet1().sendKeys(street1);
        page.getInstance(ChangeBillingAddress.class).getCity().sendKeys(city);
        WebElement RegionDropdown = page.getInstance(ChangeBillingAddress.class).getRegion();
        WebElementListHandle(RegionDropdown,state);
        page.getInstance(ChangeBillingAddress.class).getZip().sendKeys(zip);
        WebElement countryDropdown = page.getInstance(ChangeBillingAddress.class).getCountry();
        WebElementListHandle(countryDropdown,country);
        page.getInstance(ChangeBillingAddress.class).getTelephone().sendKeys(telephone);
        page.getInstance(ChangeBillingAddress.class).getSaveButton().click();

        actualAddress = page.getInstance(ChangeBillingAddress.class).printElementInfo(); System.out.println(actualAddress+"____"+expectedAddress);
        SoftAssert softAssert = new SoftAssert();
        for (String key : actualAddress.keySet()) {
            softAssert.assertEquals(actualAddress.get(key), expectedAddress.get(key), key + " does not match!");
        }
        softAssert.assertAll();

    }

    private void WebElementListHandle(WebElement drop, String value) throws NoSuchElementException {
        try {
            Select select = new Select(drop);
            List<WebElement> Types = select.getOptions();
            for(WebElement type : Types){
                if(type.getText().equalsIgnoreCase(value)){
                    type.click(); break;
                }
            }
        }
        catch (TimeoutException ignored){}
    }
}