package tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.MainPage;
import page_objects.SingInPage;
import java.util.concurrent.TimeUnit;
import static navigation.ApplicationURLs.applicationUrl;

public class ExistingUserSingInPositiveTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(applicationUrl);
    }

    @Test
    public void userProperSingInToExistingAccount(){

        MainPage startPage = new MainPage(driver);
        SingInPage singIn = new SingInPage(driver);

        startPage.userClickedOnSingInButtonInTheTopOfPage();
        singIn.userTypedEmailAddresInTheSingInField();
        singIn.userTypedPassword();
        singIn.userClickedOnSingInButton();

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();

    }
}