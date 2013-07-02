package br.com.uoldiveo.painel.administracao.professionalservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalServicesNovoOrcamentoPage {

	private WebDriver driver;

	public ProfessionalServicesNovoOrcamentoPage(WebDriver driver) {

		this.driver = driver;

	}

	public ProfessionalServicesOrcamentosSolicitadosPage solicita(String produtoservico, String descricao) {

		Select cbProdutoServico = new Select(driver.findElement(By
				.id("idClassificationCall")));
		WebElement txtDescricao = driver.findElement(By.id("call-infotext"));

		cbProdutoServico.selectByVisibleText(produtoservico);

		txtDescricao.sendKeys(descricao);
		txtDescricao.submit();
		
		return new ProfessionalServicesOrcamentosSolicitadosPage(driver);

	}

}
