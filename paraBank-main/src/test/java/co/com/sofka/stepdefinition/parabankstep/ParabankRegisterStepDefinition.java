package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankRegisterStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterStepDefinition.class);
    private ParabankModel parabankModel = new ParabankModel();
    private ParabankRegisterPage parabankRegisterPage;

    @Given("^el cliente entra en la seccion de Registro del sitio Web de Parabank$")
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

    @When("^el cliente ingresa un primer nombre: (.+), un apellido: (.+), una direccion: (.+), una ciudad: (.+)$")
    public void elClienteIngresaUnPrimerNombreUnApellidoUnaDireccionUnaCiudad(String fName, String lName, String address, String city) throws Throwable {

        try{
            parabankModel.setFirstNameRegister(fName);
            parabankModel.setLastNameRegister(lName);
            parabankModel.setAddressRegister(address);
            parabankModel.setCityRegister(city);
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("^el cliente ingresa un estado/provincia: (.+), un codigo postal: (.+), un telefono: (.+)$")
    public void elClienteIngresaUnEstadoProvinciaUnCodigoPostalUnTelefono(String state, String zCode, String phone) throws Throwable {

        try{
            parabankModel.setStateRegister(state);
            parabankModel.setZipCodeRegister(zCode);
            parabankModel.setPhoneRegister(phone);
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("^el cliente ingresa un numero de seguro social: (.+), un usuario: (.+), una contrasena: (.+) y una confirmacion de contrasena: (.+) y clickea el boton Register$")
    public void elClienteIngresaUnNumeroDeSeguroSocialUnUsuarioUnaContraseaYUnaConfirmacinDeContrasena(String ssn, String user, String pass, String passConf) throws Throwable {

        try{
            parabankModel.setSsnRegister(ssn);
            parabankModel.setUsernameRegister(user);
            parabankModel.setPasswordRegister(pass);
            parabankModel.setConfirmPassRegister(passConf);
            parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("^recibira un mensaje de bienvenida (.+)$")
    public void recibiraUnMensajeDeBienvenida(String confMess) throws Throwable {

        Assertions.assertEquals(confMess,parabankRegisterPage.isRegisterDone());
        quiteDriver();
    }

}
