package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Base;
import support.ConfigUtil;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends Base {
    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setUp() {
        driver = Base.getDriver();
        driver.get(ConfigUtil.get("baseUrl"));
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        Base.closeDriver();
   }

    @Dado("que estou logado no sistema")
    public void queEstouLogadoNoSistema() {
        String email = ConfigUtil.get("login.email");
        String password = ConfigUtil.get("login.password");
        loginPage.login(email, password);
    }

    @Entao("eu devo ver a mensagem de {string}")
    public void euDevoVerAMensagem(String mensagemEsperada) {
        WebElement mensagemElemento = loginPage.getWelcomeMessage();
        String mensagemAtual = mensagemElemento.getText();
        assertTrue("A mensagem não foi encontrada: " + mensagemEsperada, mensagemAtual.contains(mensagemEsperada));
    }
}