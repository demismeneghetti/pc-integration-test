package br.com.uoldiveo.painel.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesNovoOrcamentoPage;
import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesOrcamentosSolicitadosPage;

public class HomeExternalPage {

	private WebDriver driver;

	public HomeExternalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void acessa() {
		driver.get("https://painel.uoldiveo.com.br");
	}

	public ProfessionalServicesOrcamentosSolicitadosPage OrcamentosSolicitados() {
		WebElement clickOrcamentosSolicitados = driver.findElement(By
				.linkText("Orçamentos solicitados"));
		
		clickOrcamentosSolicitados.click();
		
		return new ProfessionalServicesOrcamentosSolicitadosPage(driver);
	}

	public ProfessionalServicesNovoOrcamentoPage NovoOrcamento() {
		WebElement clickNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		
		clickNovoOrcamento.click();
		
		return new ProfessionalServicesNovoOrcamentoPage(driver);
	}

}
