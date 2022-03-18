package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
import co.com.sofka.page.parabank.ParabankRegisterPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankLoginStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankLoginStepDefinition.class);
    private ParabankModel parabankModel;
    private ParabankLogInPage parabankLogInPage;
    private static final String NOT_PASS_IN_LOGIN = "NOT PASSWORD IN LOGIN PAGE";

    @Given("el cliente ingresa en la Opcion de Login del sitio Web de Parabank")
    public void elClienteIngresaEnLaOpcinDeLoginDelDitioWebDeParabank() throws Throwable {

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

    @When("el cliente ingresa su informacion de usuario y da click en Log In")
    public void elClienteIngresaUnUsuarioUnaContrasenaYDaClickEnLogIn() throws Throwable {

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

            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();

            ParabankRegisterPage parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

            parabankLogInPage = new ParabankLogInPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankLogInPage.fillLogin();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("el cliente ingresa un usuario y da click en Log In")
    public void elClienteIngresaUnUsuarioYDaClickEnLogIn() throws Throwable {

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

            parabankModel.setUsernameLogin();

            ParabankRegisterPage parabankRegisterPage = new ParabankRegisterPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankRegisterPage.fillRegister();

            parabankLogInPage = new ParabankLogInPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankLogInPage.fillLogin();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("recibira un mensaje de informacion sobre su cuenta")
    public void recibiraUnMensajeDeInformacionSobreSuCuenta() throws Throwable {

        Assertions.assertEquals(forSubmittedLogin(), parabankLogInPage.isLoginDone());
        quiteDriver();
    }

    @Then("recibira un mensaje de error indicando que se debe ingresar un usuario y contrasena")
    public void recibiraUnMensajeDeErrorIndicandoQueSeDebeIngresarUnUsuarioYContrasena() throws Throwable {

        Assertions.assertEquals(notPassInLogin(), parabankLogInPage.notPassInLoginPage());
        quiteDriver();
        LOGGER.warn(NOT_PASS_IN_LOGIN);
    }

    private String forSubmittedLogin() {
        String submitedLogin;
        submitedLogin = "Available Amount";
        return submitedLogin;
    }

    private String notPassInLogin() {
        String notPassInLoginPage;
        notPassInLoginPage = "Please enter a username and password.";
        return notPassInLoginPage;
    }
}
