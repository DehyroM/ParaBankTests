package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ParabankLogInPage extends CommonActionsOnPage {

    private static final Logger LOGGER = Logger.getLogger(ParabankLogInPage.class);
    private ParabankModel parabankModel;
    private static final String MODEL_NULL_MESSAGE = "NO SE ENCUENTRA LA PÁGINA BUSCADA!";

    // Constructor:
    public ParabankLogInPage(WebDriver driver, ParabankModel parabankModel, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    // Input test cases:

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/p[1]/b")
    private WebElement loginPageLocator;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[1]/input")
    private WebElement usernameLogin;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[2]/input")
    private WebElement passwordLogin;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement sendToLogin;

    //For Assertions Test Case:

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"accountTable\"]/thead/tr/th[3]")
    private WebElement assertionMessageUserLogin;

    //Functionalities:

    public void fillLogin(){

        if(isDisplayed(loginPageLocator)) {

            scrollOn(usernameLogin);
            clearOn(usernameLogin);
            typeOn(usernameLogin, parabankModel.getUsernameLogin());

            scrollOn(passwordLogin);
            clearOn(passwordLogin);
            typeOn(passwordLogin, parabankModel.getPasswordLogin());

            scrollOn(sendToLogin);
            doSubmit(sendToLogin);

        }else{
            LOGGER.warn(MODEL_NULL_MESSAGE);
        }
    }

    public String isLoginDone(){
        String submitedLogin ;
        submitedLogin = getText(assertionMessageUserLogin).trim();
        return submitedLogin;
    }

}
