package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import co.com.sofka.util.AleatoryFields;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankRegisterStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterStepDefinition.class);
    private static final String MESSAGE_CONFIRM = "PASSWORDS DO NOT MATCH";
    private ParabankModel parabankModel;
    private ParabankRegisterPage parabankRegisterPage;
    private AleatoryFields aleatoryFields;

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

            aleatoryFields = new AleatoryFields();
            List<String> newFields = aleatoryFields.Fields();

            parabankModel = new ParabankModel();
            parabankModel.setFirstNameRegister(newFields.get(0));
            parabankModel.setLastNameRegister(newFields.get(1));
            parabankModel.setAddressRegister(newFields.get(2));
            parabankModel.setCityRegister(newFields.get(3));
            parabankModel.setStateRegister(newFields.get(4));
            parabankModel.setZipCodeRegister(newFields.get(5));
            parabankModel.setPhoneRegister(newFields.get(6));
            parabankModel.setSsnRegister(newFields.get(7));
            parabankModel.setUsernameRegister(newFields.get(8));
            parabankModel.setPasswordRegister(newFields.get(9));
            parabankModel.setConfirmPassRegister(newFields.get(9));

            parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("recibira un mensaje de bienvenida o de advertencia: (.+)")
    public void recibiraUnMensajeDeBienvenida() throws Throwable {

        Assertions.assertEquals(forSubmittedRegister(),parabankRegisterPage.isRegisterDone());
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
