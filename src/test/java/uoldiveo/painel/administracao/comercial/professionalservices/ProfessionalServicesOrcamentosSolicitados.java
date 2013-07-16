package uoldiveo.painel.administracao.comercial.professionalservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesNovoOrcamento;


public class ProfessionalServicesOrcamentosSolicitados {

	private WebDriver driver;

	public ProfessionalServicesOrcamentosSolicitados(WebDriver driver) {
		this.driver = driver;
	}

	public ProfessionalServicesNovoOrcamento novoOrcamento() {

		WebElement btNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		btNovoOrcamento.click();

		return new ProfessionalServicesNovoOrcamento(driver);

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

	public boolean validaMensagem(String mensagem) {

		return driver.getPageSource().contains(mensagem);

	}
	
	
}
