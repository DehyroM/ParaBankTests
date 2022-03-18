package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankLoginTest extends WebUi {

    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankLoginTest.class);

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            parabankModel = new ParabankModel();

            parabankModel.setFirstNameRegister();
            parabankModel.setLastNameRegister();
            parabankModel.setAddressRegister();
            parabankModel.setCityRegister();
            parabankModel.setStateRegister();
            parabankModel.setZipCodeRegister();
            parabankModel.setPhoneRegister();
            parabankModel.setSsnRegister();
            parabankModel.setUsernameRegister();
            parabankModel.setPasswordRegister();
            parabankModel.setConfirmPassRegister();

            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();

            ParabankRegisterPage parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestLogin(){
        try{
            ParabankLogInPage parabankLogInPage = new ParabankLogInPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankLogInPage.fillLogin();
            Assertions.assertEquals(forSubmittedLogin(), parabankLogInPage.isLoginDone());
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @AfterEach
    public void tearDown(){
        quiteDriver();
    }

    private String forSubmittedLogin() {
        String submitedLogin;
        submitedLogin = "Available Amount";
        return submitedLogin;
    }
}
