package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ParabankRegisterPage extends CommonActionsOnPage {

    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterPage.class);
    private ParabankModel parabankModel;
    private static final String MODEL_NULL_MESSAGE = "NO SE ENCUENTRA LA PÁGINA BUSCADA!";

    // Constructor:
    public ParabankRegisterPage(WebDriver driver, ParabankModel parabankModel, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    // Input test cases:

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement btnRegister;

    @CacheLookup
    @FindBy(id= "customerForm")
    private WebElement registerPageLocator;

    @CacheLookup
    @FindBy(id= "customer.firstName")
    private WebElement firstNameRegister;

    @CacheLookup
    @FindBy(id= "customer.lastName")
    private WebElement lastNameRegister;

    @CacheLookup
    @FindBy(id= "customer.address.street")
    private WebElement addressRegister;

    @CacheLookup
    @FindBy(id= "customer.address.city")
    private WebElement cityRegister;

    @CacheLookup
    @FindBy(id= "customer.address.state")
    private WebElement stateRegister;

    @CacheLookup
    @FindBy(id= "customer.address.zipCode")
    private WebElement zipCodeRegister;

    @CacheLookup
    @FindBy(id= "customer.phoneNumber")
    private WebElement phoneRegister;

    @CacheLookup
    @FindBy(id= "customer.ssn")
    private WebElement ssnRegister;

    @CacheLookup
    @FindBy(id= "customer.username")
    private WebElement usernameRegister;

    @CacheLookup
    @FindBy(id= "customer.password")
    private WebElement passwordRegister;

    @CacheLookup
    @FindBy(id= "repeatedPassword")
    private WebElement confirmPassRegister;

    @CacheLookup
    @FindBy(css= "input[value=Register]")
    private WebElement applyRegister;

    //For Assertions Test Case:

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"rightPanel\"]/h1")
    private WebElement assertionMessageUserRegistration;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"repeatedPassword.errors\"]")
    private WebElement assertionMessagePassRepeated;

    //Functionalities:

    public void fillRegister(){
        scrollOn(btnRegister);
        clickOn(btnRegister);

        if(isDisplayed(registerPageLocator)) {

            scrollOn(firstNameRegister);
            clearOn(firstNameRegister);
            typeOn(firstNameRegister, parabankModel.getFirstNameRegister());

            scrollOn(lastNameRegister);
            clearOn(lastNameRegister);
            typeOn(lastNameRegister, parabankModel.getLastNameRegister());

            scrollOn(addressRegister);
            clearOn(addressRegister);
            typeOn(addressRegister, parabankModel.getAddressRegister());

            scrollOn(cityRegister);
            clearOn(cityRegister);
            typeOn(cityRegister, parabankModel.getCityRegister());

            scrollOn(stateRegister);
            clearOn(stateRegister);
            typeOn(stateRegister, parabankModel.getStateRegister());

            scrollOn(zipCodeRegister);
            clearOn(zipCodeRegister);
            typeOn(zipCodeRegister, parabankModel.getZipCodeRegister());

            scrollOn(phoneRegister);
            clearOn(phoneRegister);
            typeOn(phoneRegister, parabankModel.getPhoneRegister());

            scrollOn(ssnRegister);
            clearOn(ssnRegister);
            typeOn(ssnRegister, parabankModel.getSsnRegister());

            scrollOn(usernameRegister);
            clearOn(usernameRegister);
            typeOn(usernameRegister, parabankModel.getUsernameRegister());

            scrollOn(passwordRegister);
            clearOn(passwordRegister);
            typeOn(passwordRegister, parabankModel.getPasswordRegister());

            scrollOn(confirmPassRegister);
            clearOn(confirmPassRegister);
            typeOn(confirmPassRegister, parabankModel.getConfirmPassRegister());

            scrollOn(applyRegister);
            doSubmit(applyRegister);

        }else{
            LOGGER.warn(MODEL_NULL_MESSAGE);
        }
    }

    public String isRegisterDone(){

        String submitedRegister;

        if(isDisplayed(assertionMessagePassRepeated)){
            submitedRegister = getText(assertionMessagePassRepeated).trim();
        }else {
            submitedRegister = getText(assertionMessageUserRegistration).trim();
        }
        return submitedRegister;
    }
}
