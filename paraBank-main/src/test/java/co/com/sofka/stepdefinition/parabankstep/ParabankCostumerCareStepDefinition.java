package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import co.com.sofka.util.AleatoryFields;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankCostumerCareStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankCostumerCareStepDefinition.class);
    private ParabankModel parabankModel;
    private ParabankContactUsPage parabankContactUsPage;
    private AleatoryFields aleatoryFields;

    @Given("el cliente entra en la seccion Contact Us del sitio Web de Parabank")
    public void elClienteEntraEnLaSeccionContactUsDelSitioWebDeParabank() throws Throwable {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("el cliente ingresa una informacion de contacto y clickea el boton Send to Customer Care")
    public void elCienteingresaSuNombreSuEmailSuNumeroDeTelefonoYUnMensaje() throws Throwable {

        try{
            aleatoryFields = new AleatoryFields();

            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs(aleatoryFields.Fields().get(10));
            parabankModel.setEmailContactUs(aleatoryFields.Fields().get(11));
            parabankModel.setPhoneContactUs(aleatoryFields.Fields().get(6));
            parabankModel.setMessageContactUs(aleatoryFields.Fields().get(12));

            parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankContactUsPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }

    @Then("recibira un mensaje de confirmacion por diligenciar la peticion")
    public void recibiraUnMensajeDeConfirmacionPorDiligenciarLaPeticion() throws Throwable {

        Assertions.assertEquals(forSubmittedContactUs(),parabankContactUsPage.isContactUsDone());
        quiteDriver();

    }

    private String forSubmittedContactUs(){
        String submitedsendToCostumerCare;
        submitedsendToCostumerCare = "Thank you "+parabankModel.getNameContactUs();
        return submitedsendToCostumerCare;
    }
}
