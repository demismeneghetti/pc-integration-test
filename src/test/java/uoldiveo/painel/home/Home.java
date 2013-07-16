package uoldiveo.painel.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesNovoOrcamento;
import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesOrcamentosSolicitados;


public class Home {

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void acessa() {
		driver.get("https://painel.uoldiveo.com.br");
	}

	public ProfessionalServicesOrcamentosSolicitados OrcamentosSolicitados() {
		WebElement clickOrcamentosSolicitados = driver.findElement(By
				.linkText("Professional services"));
		
		clickOrcamentosSolicitados.click();
		
		return new ProfessionalServicesOrcamentosSolicitados(driver);
	}

	public ProfessionalServicesNovoOrcamento NovoOrcamento() {
		WebElement clickNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		
		clickNovoOrcamento.click();
		
		return new ProfessionalServicesNovoOrcamento(driver);
	}

}
