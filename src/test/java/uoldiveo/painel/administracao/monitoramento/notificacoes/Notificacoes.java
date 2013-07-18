package uoldiveo.painel.administracao.monitoramento.notificacoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public boolean validaNotificacoesListaDeRegras(String title, String botao, String detalhePS, String detalheData,
	    String detalheStatus, String detalheLink) {

	return driver.getPageSource().contains(title) && driver.getPageSource().contains(botao)
		&& driver.getPageSource().contains(detalhePS) && driver.getPageSource().contains(detalheData)
		&& driver.getPageSource().contains(detalheStatus) && driver.getPageSource().contains(detalheLink);

    }

    public boolean validaMensagem(String mensagem) {

	return driver.getPageSource().contains(mensagem);

    }

}
