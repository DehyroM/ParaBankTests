package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankRegisterTest extends WebUi {

    private ParabankModel parabankModel;
    private static final String MESSAGE_CONFIRM = "PASSWORDS DO NOT MATCH";
    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterTest.class);

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            parabankModel = new ParabankModel();
            parabankModel.setFirstNameRegister("Dehyro");
            parabankModel.setLastNameRegister("Barrera");
            parabankModel.setAddressRegister("Calle 24A sur # 4-58 Apto. 201");
            parabankModel.setCityRegister("Pitalito");
            parabankModel.setStateRegister("Huila");
            parabankModel.setZipCodeRegister("417030");
            parabankModel.setPhoneRegister("3185610660");
            parabankModel.setSsnRegister("2154968732"); //*
            parabankModel.setUsernameRegister("dmc02"); //*
            parabankModel.setPasswordRegister("pass2305");
            parabankModel.setConfirmPassRegister("pass2304");
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsRegister(){
        try{
            ParabankRegisterPage parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();
            Assertions.assertEquals(forSubmittedRegister(),parabankRegisterPage.isRegisterDone());
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

    private String forSubmittedRegister(){
        String submitedRegister;
        if(parabankModel.getPasswordRegister()!=parabankModel.getConfirmPassRegister()){
            submitedRegister = "Passwords did not match.";
            LOGGER.info(MESSAGE_CONFIRM);
        }else{
            submitedRegister = "Welcome "+parabankModel.getUsernameRegister();
        }
        return submitedRegister;
    }

}
