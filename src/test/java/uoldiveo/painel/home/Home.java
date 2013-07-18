package uoldiveo.painel.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uoldiveo.painel.administracao.comercial.oportunidadesdenegocio.NegociacoesComerciais;
import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServices;
import uoldiveo.painel.administracao.monitoramento.notificacoes.Notificacoes;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
	this.driver = driver;
    }

    public void acessaExternal() {
	driver.get("https://painel.uoldiveo.com.br");
    }

    public void acessaInternal() {
	driver.get("https://painel.uoldiveo.intranet");
    }

    // ADMINISTRACAO
    // // COMERCIAL
    // // // PROFESSIONAL SERVICES // INTERNAL // EXTERNAL
    public ProfessionalServices ProfessionalServices() {
	WebElement clickProfessionalServices = driver.findElement(By.linkText("Professional services"));

	clickProfessionalServices.click();
	return new ProfessionalServices(driver);
    }

    // // // OPORTUNIDADES DE NEGOCIOS // INTERNAL // EXTERNAL
    public NegociacoesComerciais NegociacoesComerciais() {
	WebElement clickNegociacoesComerciais = driver.findElement(By.linkText("Negociações comerciais"));

	clickNegociacoesComerciais.click();

	return new NegociacoesComerciais(driver);
    }

    // // MONITORAMENTO
    // // // Notificações // INTERNAL // EXTERNAL
    public Notificacoes Notificacoes() {
	WebElement clickNotificacoes = driver.findElement(By.linkText("Notificações"));

	clickNotificacoes.click();

	return new Notificacoes(driver);

    }

}
