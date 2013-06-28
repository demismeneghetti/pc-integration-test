package br.com.uoldiveo.painel.administracao.professional.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalServicesNovoOrcamentoPage {

	private WebDriver driver;

	public ProfessionalServicesNovoOrcamentoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void solicita() {

		Select cbProdutoServico = new Select(driver.findElement(By.id("idClassificationCall")));
		WebElement txtDescricao = driver.findElement(By.id("call-infotext"));

		txtDescricao.submit();
	}
}
