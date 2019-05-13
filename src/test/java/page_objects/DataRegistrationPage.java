package page_objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import static user_data.UserDataForm.*;

public class DataRegistrationPage {

    WebDriver driver;

    public DataRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Logger logger = LogManager.getRootLogger();


    @FindBy(id = "id_gender1")
    private WebElement radioButtonMale;

    @FindBy(id = "id_gender2")
    private WebElement radioButtonFemale;

    @FindBy(id = "customer_firstname")
    private WebElement firstCustomerNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastCustomerNameField;

    @FindBy(id = "firstname")
    private WebElement firstCustomerNameSecondField;

    @FindBy(id = "lastname")
    private WebElement lastCustomerNameSecondField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailAddressGeristrationFormField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement newPasswordField;

    @FindBy(id = "days")
    private WebElement dateDayDropdown;

    @FindBy(id = "months")
    private WebElement dateMonthsDropdown;

    @FindBy(id = "years")
    private WebElement dateYearsDropdown;

    @FindBy(id = "company")
    private WebElement companyNameField;

    @FindBy(id = "address1")
    private WebElement fisrtLineAddressField;

    @FindBy(id = "address2")
    private WebElement secondLineAddressField;

    @FindBy(id = "city")
    private WebElement cityAddressFiled;

    @FindBy(id = "id_state")
    private WebElement stateChooseDropdown;

    @FindBy(id = "postcode")
    private WebElement postcodeAddressFiled;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneFormFiled;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckBoxOnForm;

    @FindBy(id = "optin")
    private WebElement specialsOffersCheckBoxOnForm;

    @FindBy(id = "alias")
    private WebElement aliasForFutureReferenceFiled;

    @FindBy(id = "submitAccount")
    private WebElement registerButtonOnForm;

    @FindBy(id = "id_country")
    private WebElement selectCountryDropdown;


    public void userChooseOwnSex() {
        radioButtonMale.click();
        Assert.assertTrue(radioButtonMale.isSelected());
        Assert.assertFalse(radioButtonFemale.isSelected());
        logger.info("Gender selection, click on the radiobutton");
    }


    public void userFillsFirstName() {
        firstCustomerNameField.clear();
        firstCustomerNameField.sendKeys(firstUserName);
        firstCustomerNameField.click();
        Assert.assertEquals(firstUserName, firstCustomerNameField.getAttribute("value"));
        logger.info("Filling in the field with the name");
    }

    public void userFillsLastName() {
        lastCustomerNameField.clear();
        lastCustomerNameField.sendKeys(lastUserName);
        Assert.assertEquals(lastUserName, lastCustomerNameField.getAttribute("value"));
        Assert.assertEquals(email,emailAddressGeristrationFormField.getAttribute("value"));
        logger.info("Filling in the field with the last name");
    }

    public void userTypedEmailAddressRegistrationForm() {
        emailAddressGeristrationFormField.clear();
        emailAddressGeristrationFormField.sendKeys(email);
        Assert.assertEquals(email,emailAddressGeristrationFormField.getAttribute("value"));
        logger.info("Filling in the field with the email address");

    }


    public void userTypedPasswordRegistrationForm() {
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
        Assert.assertEquals(newPassword,newPasswordField.getAttribute("value"));
        logger.info("Filling in the field with the password");

    }

    public void userFillsDateOfBirth() {
        WebElement dayDropdownWebElement = dateDayDropdown;
        Select dayDropdown = new Select(dayDropdownWebElement);
        dayDropdown.selectByValue("10");
        Assert.assertFalse(dayDropdown.isMultiple());
        logger.info("Filling in the field with the day of birth");

        WebElement monthDropdownWebElement = dateMonthsDropdown;
        Select monthDropdown = new Select(monthDropdownWebElement);
        monthDropdown.selectByValue("8");
        Assert.assertFalse(monthDropdown.isMultiple());
        logger.info("Filling in the field with the month of birth");


        WebElement yearDropdownWebElment = dateYearsDropdown;
        Select yearDropdown = new Select(yearDropdownWebElment);
        yearDropdown.selectByValue("2000");
        Assert.assertFalse(yearDropdown.isMultiple());
        logger.info("Filling in the field with the year of birth");
    }

    public void userSubscribesToTheNewsletter() {
        newsletterCheckBoxOnForm.click();
        Assert.assertTrue(newsletterCheckBoxOnForm.isSelected());
        logger.info("Select newsletter checkbox");
    }

    public void userSubscribesToTheSpecialOffers() {
        specialsOffersCheckBoxOnForm.click();
        Assert.assertTrue(specialsOffersCheckBoxOnForm.isSelected());
        logger.info("Select special offers checkbox");

    }

    public void userFillsDetailsOwnAccount() {

        Assert.assertEquals(firstUserName, firstCustomerNameSecondField.getAttribute("value"));
        Assert.assertEquals(lastUserName, lastCustomerNameSecondField.getAttribute("value"));

        companyNameField.clear();
        companyNameField.sendKeys(companyName);
        Assert.assertEquals(companyNameField.getAttribute("value"), companyName);
        logger.info("Filling in the field with the company name");

        fisrtLineAddressField.clear();
        fisrtLineAddressField.sendKeys(addressStreet);
        Assert.assertEquals(fisrtLineAddressField.getAttribute("value"), addressStreet);
        logger.info("Filling in the field with the company address-street");

        secondLineAddressField.clear();
        secondLineAddressField.sendKeys(addressNumber);
        Assert.assertEquals(addressNumber, secondLineAddressField.getAttribute("value"));
        logger.info("Filling in the field with the company address-building no.");

        cityAddressFiled.clear();
        cityAddressFiled.sendKeys(adressCity);
        Assert.assertEquals(adressCity, cityAddressFiled.getAttribute("value"));
        logger.info("Filling in the field with the company address-city");
    }


    public void userChooseOwnState() {
        WebElement stateWebElement = stateChooseDropdown;
        Select stateChooseDropdown = new Select(stateWebElement);

        List<WebElement> options = stateChooseDropdown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("-");
        expectedNamesOfOptions.add("Alabama");
        expectedNamesOfOptions.add("Alaska");
        expectedNamesOfOptions.add("Arizona");
        expectedNamesOfOptions.add("Arkansas");
        expectedNamesOfOptions.add("California");
        expectedNamesOfOptions.add("Colorado");
        expectedNamesOfOptions.add("Connecticut");
        expectedNamesOfOptions.add("Delaware");
        expectedNamesOfOptions.add("District of Columbia");
        expectedNamesOfOptions.add("Florida");
        expectedNamesOfOptions.add("Georgia");
        expectedNamesOfOptions.add("Hawaii");
        expectedNamesOfOptions.add("Idaho");
        expectedNamesOfOptions.add("Illinois");
        expectedNamesOfOptions.add("Indiana");
        expectedNamesOfOptions.add("Iowa");
        expectedNamesOfOptions.add("Kansas");
        expectedNamesOfOptions.add("Kentucky");
        expectedNamesOfOptions.add("Louisiana");
        expectedNamesOfOptions.add("Maine");
        expectedNamesOfOptions.add("Maryland");
        expectedNamesOfOptions.add("Massachusetts");
        expectedNamesOfOptions.add("Michigan");
        expectedNamesOfOptions.add("Minnesota");
        expectedNamesOfOptions.add("Mississippi");
        expectedNamesOfOptions.add("Missouri");
        expectedNamesOfOptions.add("Montana");
        expectedNamesOfOptions.add("Nebraska");
        expectedNamesOfOptions.add("Nevada");
        expectedNamesOfOptions.add("New Hampshire");
        expectedNamesOfOptions.add("New Jersey");
        expectedNamesOfOptions.add("New Mexico");
        expectedNamesOfOptions.add("New York");
        expectedNamesOfOptions.add("North Carolina");
        expectedNamesOfOptions.add("North Dakota");
        expectedNamesOfOptions.add("Ohio");
        expectedNamesOfOptions.add("Oklahoma");
        expectedNamesOfOptions.add("Oregon");
        expectedNamesOfOptions.add("Pennsylvania");
        expectedNamesOfOptions.add("Puerto Rico");
        expectedNamesOfOptions.add("Rhode Island");
        expectedNamesOfOptions.add("South Carolina");
        expectedNamesOfOptions.add("South Dakota");
        expectedNamesOfOptions.add("Tennessee");
        expectedNamesOfOptions.add("Texas");
        expectedNamesOfOptions.add("US Virgin Islands");
        expectedNamesOfOptions.add("Utah");
        expectedNamesOfOptions.add("Vermont");
        expectedNamesOfOptions.add("Virginia");
        expectedNamesOfOptions.add("Washington");
        expectedNamesOfOptions.add("West Virginia");
        expectedNamesOfOptions.add("Wisconsin");
        expectedNamesOfOptions.add("Wyoming");
        System.out.println(expectedNamesOfOptions);
        stateChooseDropdown.selectByVisibleText("Florida");
        Assert.assertEquals(namesOfOptions, expectedNamesOfOptions);
        stateChooseDropdown.selectByVisibleText("Florida");
        logger.info("Choice of the state of residence");
    }

    public void userTypedZipCode() {
        postcodeAddressFiled.clear();
        postcodeAddressFiled.sendKeys(postCode);
        Assert.assertEquals(postCode, postcodeAddressFiled.getAttribute("value"));
        logger.info("Filling in the field with the company address-zip code");
    }

    public void userTypedPhoneNumber() {
        mobilePhoneFormFiled.clear();
        mobilePhoneFormFiled.sendKeys(mobilePhoneNumber);
        Assert.assertEquals(mobilePhoneNumber, mobilePhoneFormFiled.getAttribute("value"));
        logger.info("Filling in the field with the mobile phone number");
    }


    public void userChoosedOwnCountry() {
        WebElement countryWebElement = selectCountryDropdown;
        Select selectCountryDropdown = new Select(countryWebElement);

        List<WebElement> options = selectCountryDropdown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("-");
        expectedNamesOfOptions.add("United States");
        System.out.println(expectedNamesOfOptions);
        Assert.assertEquals(namesOfOptions, expectedNamesOfOptions);
        logger.info("Choice of the country of residence");
    }

    public void userGiveFutureReference() {
        aliasForFutureReferenceFiled.clear();
        aliasForFutureReferenceFiled.sendKeys(alias);
        Assert.assertEquals(alias, aliasForFutureReferenceFiled.getAttribute("value"));
        logger.info("Filling in the field with the future reference");

    }

    public void userClickedOnRegistrationButton() {
        Assert.assertTrue(registerButtonOnForm.isDisplayed());
        registerButtonOnForm.click();
        logger.info("Click on register a new account ");
    }


}
