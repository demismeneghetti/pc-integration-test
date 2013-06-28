package br.com.uoldiveo.painel.administracao.professional.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.uoldiveo.painel.administracao.professional.services.ProfessionalServicesNovoOrcamentoPage;

public class ProfessionalServicesOrcamentosSolicitadosPage {

	public WebDriver driver;

	public ProfessionalServicesOrcamentosSolicitadosPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProfessionalServicesNovoOrcamentoPage novoOrcamento() {

		WebElement btNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		btNovoOrcamento.click();
		
		return new ProfessionalServicesNovoOrcamentoPage(driver);

	}
}
