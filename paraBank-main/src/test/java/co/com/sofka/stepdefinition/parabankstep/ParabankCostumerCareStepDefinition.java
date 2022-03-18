package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
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
    private static final String NO_NAME_IN_CONTACT_US = "NAME IS REQUIRED";

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
            parabankModel = new ParabankModel();

            parabankModel.setNameContactUs();
            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();
            parabankModel.setMessageContactUs();

            parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankContactUsPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("el cliente ingresa una informacion de contacto pero sin ingresar el nombre y clickea el boton Send to Customer Care")
    public void elCienteingresaUnaInformacionDeContactoPeroSinIngresarElNombre() throws Throwable {

        try{
            parabankModel = new ParabankModel();

            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();
            parabankModel.setMessageContactUs();

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

    @Then("recibira un mensaje de error indicando que se requiere el nombre")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElNombre() throws Throwable {

        Assertions.assertEquals(forNotNameInContactUs(),parabankContactUsPage.isNotNameInContactUs());
        LOGGER.warn(NO_NAME_IN_CONTACT_US);
        quiteDriver();
    }

    private String forSubmittedContactUs(){
        String submitedsendToCostumerCare;
        submitedsendToCostumerCare = "Thank you "+parabankModel.getNameContactUs();
        return submitedsendToCostumerCare;
    }

    private String forNotNameInContactUs(){
        String notNameAndSendToCostumerCare;
        notNameAndSendToCostumerCare = "Name is required.";
        return notNameAndSendToCostumerCare;
    }
}
