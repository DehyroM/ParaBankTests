package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
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

    @Given("^el cliente ingresa en la Opcion de Login del sitio Web de Parabank$")
    public void el_cliente_ingresa_en_la_opcin_de_login_del_sitio_web_de_parabank() throws Throwable {

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

    @When("^el cliente ingresa un usuario: (.+), una contrasena: (.+), y da click en Log In$")
    public void el_cliente_ingresa_un_usuario_una_contrasena_y_da_click_en_log_in(String user, String pass) throws Throwable {

        try{
            parabankModel = new ParabankModel();
            parabankModel.setUsernameLogin(user);
            parabankModel.setPasswordLogin(pass);
            parabankLogInPage = new ParabankLogInPage(driver, parabankModel, TEN_SECONDS.getValue());
            parabankLogInPage.fillLogin();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }

    @Then("^recibira un mensaje de informacion sobre su cuenta (.+)$")
    public void recibira_un_mensaje_de_informacion_sobre_su_cuenta(String infMess) throws Throwable {

        Assertions.assertEquals(infMess, parabankLogInPage.isLoginDone());
        quiteDriver();
    }
}
