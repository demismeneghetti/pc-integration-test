package uoldiveo.painel.administracao.monitoramento.notificacoes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificacoesNovaNotificacao {

    private WebDriver driver;

    public NotificacoesNovaNotificacao(WebDriver driver) {

	this.driver = driver;

    }

    public void insereTituloDaNotificacao(String tituloDaNotificacao) {

	WebElement txtTituloDaNotificacao = driver.findElement(By.id("title"));
	txtTituloDaNotificacao.sendKeys(tituloDaNotificacao);

    }

    public void insereDetalhesDaNotificacao(String descricaoDaNotificacao) {

	WebElement txtDescricao = driver.findElement(By.id("description"));
	txtDescricao.sendKeys(descricaoDaNotificacao);

    }

    public void selecionaItensMonitorados(int itemMonitiorado) {

	List<WebElement> cxItemDeConfiguracaoSelecione = driver.findElement(By.id("serversAvailable")).findElements(By.tagName("li"));
	cxItemDeConfiguracaoSelecione.get(itemMonitiorado).click();

	WebElement btSelectServer = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/fieldset[2]/ul/li/button"));
	btSelectServer.click();

    }

    public void selecionaContatos(int contato) {

	List<WebElement> cxContatosSelecione = driver.findElement(By.id("availableUsers")).findElements(By.tagName("li"));
	cxContatosSelecione.get(contato).click();

	WebElement btSelectUser = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/fieldset[3]/ul/li/button"));
	btSelectUser.click();

    }

    public void selecionaTipoNotificacaoEmail(int email) {

	List<WebElement> cbSMS = driver.findElement(By.id("selectedUsers")).findElements(By.tagName("li"));
	cbSMS.get(email).findElement(By.className("usersEmailNotification")).click();

    }

    public void selecionaTipoNotificacaoSMS(int sms) {

	List<WebElement> cbEmail = driver.findElement(By.id("selectedUsers")).findElements(By.tagName("li"));
	cbEmail.get(sms).findElement(By.className("usersSmsNotification")).click();

    }

    public Notificacoes criarNotificacao() {

	WebElement btCriarNotificacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/button"));
	btCriarNotificacao.click();

	return new Notificacoes(driver);

    }
    
    public Notificacoes cancelaCriacaoNotificacao() {

	WebElement btCancelaCriacaoNotificacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/a"));
	btCancelaCriacaoNotificacao.click();

	return new Notificacoes(driver);

    }

    public boolean validaMensagem(String mensagem) {

	return driver.getPageSource().contains(mensagem);

    }
    
    

}

// BOTAO SELECIONE
// WebElement btSelect =
// driver.findElement(By.className("setAvailableSelectedItems"));
// btSelect.click();

// BOTAO SELECIONE TODOS
// WebElement btSelectAll =
// driver.findElement(By.className("setAllAvailableItems"));
// btSelectAll.isDisplayed();
//
// BOTAO REMOVER TODOS
// WebElement btRemoveAll =
// driver.findElement(By.className("removeAllSelectedItems"));
// btRemoveAll.isDisplayed();
//
// BOTAO REMOVER
// WebElement btRemove =
// driver.findElement(By.className("removeSelectedItem"));
// btRemove.isDisplayed();

// CAIXA DE ITEM MONITORADOS SELECIONADOS
// WebElement cxItemDeConfiguracaoSelecionado =
// driver.findElement(By.id("serversSelected"));

// CAIXA DE CONTATOS - SELECIONE
// List<WebElement> cxContatoSelecione =
// driver.findElements(By.id("availableUsers"));
// cxContatoSelecione.get(usuario - 1);
//
// List<WebElement> cxContatoSelecionado =
// driver.findElements(By.id("availableUsers"));
// cxContatoSelecionado.get(usuario -
// 1).findElement(By.className("usersEmailNotification")).click();
// cxContatoSelecionado.get(usuario -
// 1).findElement(By.className("usersSmsNotification")).click();
//
// WebElement btCriarNotificacao =
// driver.findElement(By.className("submitForm"));
// btCriarNotificacao.click();
//
// return new Notificacoes(driver);
//
// }
//
// public ProfessionalServicesNovoOrcamento cancelar() {
//
// WebElement btCancelar =
// driver.findElement(By.className("cancelNewProfessionalService"));
// btCancelar.click();
//
// return new ProfessionalServicesNovoOrcamento(driver);
//
// }
