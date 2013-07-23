package uoldiveo.painel.administracao.monitoramento.notificacoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notificacoes {

    private WebDriver driver;

    public Notificacoes(WebDriver driver) {

	this.driver = driver;

    }

    public NotificacoesNovaNotificacao novaRegra() {

	WebElement btCriarNovaNotificacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/a"));
	btCriarNovaNotificacao.click();

	return new NotificacoesNovaNotificacao(driver);

    }

    public NotificacoesEditarNotificacao editarRegra() {

	WebElement linkEditar = driver.findElement(By.linkText("Editar"));
	linkEditar.click();

	return new NotificacoesEditarNotificacao(driver);

    }

    public NotificacoesDetalhesDaNotificacao detalhesDaRegra() {

	WebElement linkDetalhes = driver.findElement(By.linkText("Detalhes"));
	linkDetalhes.click();

	return new NotificacoesDetalhesDaNotificacao(driver);

    }

    public void removerRegra() {

	WebElement linkRemover = driver.findElement(By
		.xpath("/html/body/div/div[2]/div[2]/form/fieldset/div/table/tbody/tr/td[3]/ul/li[3]/a"));
	linkRemover.click();

	new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("simplemodal-container")));

    }

    public void removerRegraModalFechar() {

	WebElement btFechar = driver.findElement(By.xpath("/html/body/div[3]/a"));
	btFechar.click();

    }

    public void removerRegraModalConfirmar() {

	WebElement btConfirmar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button"));
	btConfirmar.click();

    }

    public void removerRegraModalCancelar() {

	WebElement btCancelar = driver.findElement(By.id("simplemodal-container")).findElement(By.className("cancelNotificationDelete"));
	btCancelar.click();

    }

    public boolean removerRegraModalValidaTexto(String title, String mensagem, String nomeDaRegra) {

	return driver.getPageSource().contains(title) && driver.getPageSource().contains(mensagem)
		&& driver.getPageSource().contains(nomeDaRegra);

    }

    public boolean validaNotificacoesListaDeRegras(String title, String botao, String detalhePS, String detalheData, String detalheStatus,
	    String detalheLink) {

	return driver.getPageSource().contains(title) && driver.getPageSource().contains(botao)
		&& driver.getPageSource().contains(detalhePS) && driver.getPageSource().contains(detalheData)
		&& driver.getPageSource().contains(detalheStatus) && driver.getPageSource().contains(detalheLink);

    }

    public boolean validaMensagem(String mensagem) {

	return driver.getPageSource().contains(mensagem);

    }

}
