package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankCostumerCareTest extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankCostumerCareTest.class);

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            parabankModel = new ParabankModel();

            parabankModel.setNameContactUs();
            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();
            parabankModel.setMessageContactUs();

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
