package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import co.com.sofka.util.AleatoryFields;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ParabankLoginStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(ParabankLoginStepDefinition.class);
    private ParabankModel parabankModel;
    private ParabankLogInPage parabankLogInPage;
    private AleatoryFields aleatoryFields;

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
            aleatoryFields = new AleatoryFields();
            List<String> newFields = aleatoryFields.Fields();

            parabankModel = new ParabankModel();
            parabankModel.setUsernameLogin(newFields.get(8));
            parabankModel.setPasswordLogin(newFields.get(9));

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

    private String forSubmittedLogin() {
        String submitedLogin;
        submitedLogin = "Available Amount";
        return submitedLogin;
    }
}
