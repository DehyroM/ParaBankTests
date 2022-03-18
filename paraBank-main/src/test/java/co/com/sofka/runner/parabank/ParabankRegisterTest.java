package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.com.sofka.util.AleatoryFields;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankRegisterTest extends WebUi {

    private ParabankModel parabankModel;
    private static final String MESSAGE_CONFIRM = "PASSWORDS DO NOT MATCH";
    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterTest.class);

    private AleatoryFields aleatoryFields;

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            aleatoryFields = new AleatoryFields();

            parabankModel = new ParabankModel();
            parabankModel.setFirstNameRegister(aleatoryFields.Fields().get(0));
            parabankModel.setLastNameRegister(aleatoryFields.Fields().get(1));
            parabankModel.setAddressRegister(aleatoryFields.Fields().get(2));
            parabankModel.setCityRegister(aleatoryFields.Fields().get(3));
            parabankModel.setStateRegister(aleatoryFields.Fields().get(4));
            parabankModel.setZipCodeRegister(aleatoryFields.Fields().get(5));
            parabankModel.setPhoneRegister(aleatoryFields.Fields().get(6));
            parabankModel.setSsnRegister(aleatoryFields.Fields().get(7));
            parabankModel.setUsernameRegister(aleatoryFields.Fields().get(8));
            parabankModel.setPasswordRegister(aleatoryFields.Fields().get(9));
            parabankModel.setConfirmPassRegister(aleatoryFields.Fields().get(9));
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
            submitedRegister = "Welcome " + parabankModel.getUsernameRegister();
        }
        return submitedRegister;
    }

}
