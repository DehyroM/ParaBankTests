package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.com.sofka.util.AleatoryFields;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankCostumerCareTest extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankCostumerCareTest.class);
    private AleatoryFields aleatoryFields;

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            aleatoryFields = new AleatoryFields();

            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs(aleatoryFields.Fields().get(10));
            parabankModel.setEmailContactUs(aleatoryFields.Fields().get(11));
            parabankModel.setPhoneContactUs(aleatoryFields.Fields().get(6));
            parabankModel.setMessageContactUs(aleatoryFields.Fields().get(12));
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsContactUs(){
        try{
            ParabankContactUsPage parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankContactUsPage.fillContactUs();
            Assertions.assertEquals(forSubmittedContactUs(),parabankContactUsPage.isContactUsDone());
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

    private String forSubmittedContactUs(){
        String submitedsendToCostumerCare;
        submitedsendToCostumerCare = "Thank you "+parabankModel.getNameContactUs();
        return submitedsendToCostumerCare;
    }
}
