/*To check how works creation account process you should change
value of variables because existing values is already used.*/

package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.DataRegistrationPage;
import page_objects.SingInPage;

import java.util.concurrent.TimeUnit;
import static navigation.ApplicationURLs.signInSite;

public class NewUserRegistrationPositiveTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(signInSite);
    }

    @Test
    public void userRegisterNewAccount(){
        SingInPage singInSite = new SingInPage(driver);
        singInSite.userTypedEmailAddressInTheRegistrationField();
        singInSite.userClickedOnCreateAnAccountButton();

        DataRegistrationPage userFillsDataPage = new DataRegistrationPage(driver);
        userFillsDataPage.userChooseOwnSex();
        userFillsDataPage.userFillsFirstName();
        userFillsDataPage.userFillsLastName();
        userFillsDataPage.userTypedPasswordRegistrationForm();
        userFillsDataPage.userFillsDateOfBirth();
        userFillsDataPage.userSubscribesToTheNewsletter();
        userFillsDataPage.userSubscribesToTheSpecialOffers();
        userFillsDataPage.userFillsDetailsOwnAccount();
        userFillsDataPage.userChooseOwnState();
        userFillsDataPage.userTypedZipCode();
        userFillsDataPage.userChoosedOwnCountry();
        userFillsDataPage.userTypedPhoneNumber();
        userFillsDataPage.userGiveFutureReference();
        userFillsDataPage.userClickedOnRegistrationButton();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}