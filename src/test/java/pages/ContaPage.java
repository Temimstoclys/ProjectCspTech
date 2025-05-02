package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContaPage {
    private WebDriver driver;

    public ContaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarMenuContas() {
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }

    public void criarConta(String nome) {
        acessarMenuContas();
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.xpath("//button[text()='Salvar']")).click();
    }

    public String obterMensagem() {
        WebElement alerta = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        return alerta.getText();
    }

    public void acessarListaContas() {
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
    }

    public void editarConta(String nomeAntigo, String nomeNovo) {
        acessarListaContas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        clicarBotaoEditar(nomeAntigo, wait);
        preencherCampoNome(nomeNovo, wait);
        clicarBotaoSalvar(wait);
    }

    public void excluirConta(String nomeConta) {
        acessarListaContas();
        WebElement botaoExcluir = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//table//tr[td[text()='" + nomeConta + "']]//a[contains(@href, 'remover')]")));
        botaoExcluir.click();
    }

    private void clicarBotaoEditar(String nomeConta, WebDriverWait wait) {
        WebElement botaoEditar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table//tr[td[text()='" + nomeConta + "']]//a[contains(@href, 'editar')]")));
        botaoEditar.click();
    }

    private void preencherCampoNome(String novoNome, WebDriverWait wait) {
        WebElement campoNome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nome")));
        campoNome.clear();
        campoNome.sendKeys(novoNome);
    }

    private void clicarBotaoSalvar(WebDriverWait wait) {
        WebElement botaoSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Salvar']")));
        botaoSalvar.click();
    }

    public WebElement validateAccount(String accountName) {
        try {
            By accountLocator = By.xpath("//*[contains(text(),'" + accountName + "')]");
            return driver.findElement(accountLocator);
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
