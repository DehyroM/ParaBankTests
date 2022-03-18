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
    public void elClienteIngresaUnPrimerNombreUnApellidoUnaDireccionUnaCiudad(String fName, String lName, String address, String city) throws Throwable {

        try{
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
            parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("recibira un mensaje de bienvenida o de advertencia: (.+)")
    public void recibiraUnMensajeDeBienvenida(String confMess) throws Throwable {

        Assertions.assertEquals(confMess,parabankRegisterPage.isRegisterDone());
        quiteDriver();
    }

}
