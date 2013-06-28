package br.com.uoldiveo.painel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.uoldiveo.painel.administracao.professional.services.ProfessionalServicesNovoOrcamentoPage;
import br.com.uoldiveo.painel.administracao.professional.services.ProfessionalServicesOrcamentosSolicitadosPage;

public class HomeExternalPage {

	private WebDriver driver;

	public HomeExternalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessa() {
		driver.get("https://painel.uoldiveo.com.br");
	}

	public ProfessionalServicesOrcamentosSolicitadosPage OrcamentosSolicitados() {
		driver.findElement(By.linkText("Orçamentos solicitados")).click();
		return new ProfessionalServicesOrcamentosSolicitadosPage(driver);
	}
	
	public ProfessionalServicesNovoOrcamentoPage NovoOrcamento() {
		driver.findElement(By.linkText("Novo Orçamento")).click();
		return new ProfessionalServicesNovoOrcamentoPage(driver);
	}

}
