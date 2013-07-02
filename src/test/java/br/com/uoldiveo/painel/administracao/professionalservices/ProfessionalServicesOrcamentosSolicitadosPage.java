package br.com.uoldiveo.painel.administracao.professionalservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesNovoOrcamentoPage;

public class ProfessionalServicesOrcamentosSolicitadosPage {

	private WebDriver driver;

	public ProfessionalServicesOrcamentosSolicitadosPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProfessionalServicesNovoOrcamentoPage novoOrcamento() {

		WebElement btNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		btNovoOrcamento.click();

		return new ProfessionalServicesNovoOrcamentoPage(driver);

	}

	public boolean validaProfessionalServicesOrcamentosSolicitadosPage (String title,
			String botao, String detalhePS, String detalheData,
			String detalheStatus, String detalheLink) {

		return driver.getPageSource().contains(title)
				&& driver.getPageSource().contains(botao)
				&& driver.getPageSource().contains(detalhePS)
				&& driver.getPageSource().contains(detalheData)
				&& driver.getPageSource().contains(detalheStatus)
				&& driver.getPageSource().contains(detalheLink);

	}

	public boolean validaNovoOrcamentoMensagemDeSucesso(String mensagemSucesso) {

		return driver.getPageSource().contains(mensagemSucesso);

	}
}
