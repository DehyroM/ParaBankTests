package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankRegisterStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterStepDefinition.class);
    private static final String PASS_CONFIRM = "PASSWORDS DO NOT MATCH";
    private ParabankModel parabankModel;
    private ParabankRegisterPage parabankRegisterPage;

    @Given("el cliente entra en la seccion de Registro del sitio Web de Parabank")
    public void elClienteEntraEnLaSeccionDeRegistroDelSitioWebDeParabank() throws Throwable {

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

    @When("el cliente ingresa sus datos personales y clickea el boton Register")
    public void elClienteIngresaUnPrimerNombreUnApellidoUnaDireccionUnaCiudad() throws Throwable {

        try{
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

            parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("el cliente ingresa sus datos personales pero con una confirmacion de contrasena diferente a la contrasena y clickea el boton Register")
    public void elClienteIngresaSusDatosPersonalesPeroConConfirmacionDeContrasenaDiferente() throws Throwable {

        try{
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

            parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("recibira un mensaje de bienvenida")
    public void recibiraUnMensajeDeBienvenida() throws Throwable {

        Assertions.assertEquals(forSubmittedRegister(),parabankRegisterPage.isRegisterDone());
        quiteDriver();
    }

    @Then("recibira un mensaje de error indicando que las contrasenas no coinciden")
    public void recibiraUnMensajeDeError() throws Throwable {

        Assertions.assertEquals(forPassConfirmNotMatchInRegister(),parabankRegisterPage.notPassConfirmMatchInRegisterPage());
        quiteDriver();
        LOGGER.warn(PASS_CONFIRM);
    }

    private String forSubmittedRegister(){
        String submitedRegister;
        submitedRegister = "Welcome " + parabankModel.getUsernameRegister();
        return submitedRegister;
    }

    private String forPassConfirmNotMatchInRegister(){
        String notNameAndSendToCostumerCare;
        notNameAndSendToCostumerCare = "Passwords did not match.";
        return notNameAndSendToCostumerCare;
    }
}
