package page_objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "login")
    public WebElement registrationButtonInMainPageNamegSignIn;



    public void userOpenMainPageInBrowser() {
        driver.navigate().to("http://automationpractice.com/index.php");
        Assert.assertTrue(registrationButtonInMainPageNamegSignIn.isDisplayed());
    }

    public void userClickedOnSingInButtonInTheTopOfPage(){
        registrationButtonInMainPageNamegSignIn.click();
        Assert.assertTrue(registrationButtonInMainPageNamegSignIn.isDisplayed());
        logger.info("Click on sign in (main page)");

    }






}