package page_objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SingInPage {

    WebDriver driver;

    public SingInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Logger logger = LogManager.getRootLogger();

    String email = "testing@issue.com";
    String password = "Test123";

    @FindBy(id = "email_create")
    private WebElement createNewAccountEmailField;

    @FindBy(name = "email")
    private WebElement singInUserEmailField;

    @FindBy(id = "passwd")
    private WebElement singInUserPasswordField;

    @FindBy(id = "SubmitCreate")
    private WebElement createNewAccountButton;

    @FindBy(id = "SubmitLogin")
    private WebElement singInButton;

    @FindBy(className = "info-account")
    private WebElement userAlreadySingIn;


    public void userTypedEmailAddressInTheRegistrationField() {
        createNewAccountEmailField.clear();
        createNewAccountEmailField.sendKeys(email);
        Assert.assertEquals(email, createNewAccountEmailField.getAttribute("value"));
        logger.info("Filling in the e-mail address field");
    }

    public void userTypedEmailAddresInTheSingInField() {
        singInUserEmailField.clear();
        singInUserEmailField.sendKeys(email);
        Assert.assertEquals(email, singInUserEmailField.getAttribute("value"));
        logger.info("Filling in the e-mail address field");
    }

    public void userTypedPassword() {
        singInUserPasswordField.clear();
        singInUserPasswordField.sendKeys(password);
        Assert.assertEquals(password, singInUserPasswordField.getAttribute("value"));
        logger.info("Filling in the password field");
    }

    public void userClickedOnCreateAnAccountButton() {
        Assert.assertTrue(createNewAccountButton.isDisplayed());
        createNewAccountButton.click();
        logger.info("Click on create an account");
    }

    public void userClickedOnSingInButton() {
        Assert.assertTrue(singInButton.isDisplayed());
        singInButton.click();
        Assert.assertTrue(userAlreadySingIn.isDisplayed());
        logger.info("Click on sign in");
    }


}
