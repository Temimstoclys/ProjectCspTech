package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import pages.ContaPage;
import support.Base;

import static org.junit.Assert.assertTrue;

public class ContaSteps {
    private WebDriver driver = Base.getDriver();
    private ContaPage contaPage = new ContaPage(driver);

    @Quando("eu crio uma conta com o nome {string}")
    public void EuCrioUmaContaComNome(String nomeConta) {
        contaPage.criarConta(nomeConta);
    }

    @Quando("eu acesso a lista de contas")
    public void EuAcessoAListaDeContas() {
        contaPage.acessarListaContas();
    }

    @Quando("eu edito a conta chamada {string} para {string}")
    public void EuEditoAContaChamada(String nomeAntigo, String nomeNovo) {
        contaPage.editarConta(nomeAntigo, nomeNovo);
    }

    @Quando("eu excluo a conta chamada {string}")
    public void EuExcluoAContaChamada(String nomeConta) {
        contaPage.excluirConta(nomeConta);
    }

    @Entao("devo ver a mensagem de {string}")
    public void DevoVerAMensagem(String mensagemEsperada) {
        String mensagemAtual = contaPage.obterMensagem();
        assertTrue("Mensagem esperada não foi exibida.", mensagemAtual.contains(mensagemEsperada));
    }
}
