package uoldiveo.painel.administracao.professionalservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalServicesNovoOrcamento {

	private WebDriver driver;

	public ProfessionalServicesNovoOrcamento(WebDriver driver) {

		this.driver = driver;

	}

	public ProfessionalServicesOrcamentosSolicitados solicita(
			String produtoservico, String descricao) {

		Select cbProdutoServico = new Select(driver.findElement(By
				.id("idClassificationCall")));
		WebElement txtDescricao = driver.findElement(By.id("call-infotext"));

		cbProdutoServico.selectByVisibleText(produtoservico);

		txtDescricao.sendKeys(descricao);
		txtDescricao.submit();

		return new ProfessionalServicesOrcamentosSolicitados(driver);

	}

	public ProfessionalServicesNovoOrcamento cancelar() {

		WebElement btCancelar = driver.findElement(By.className("cancelNewProfessionalService"));
		btCancelar.click();

		return new ProfessionalServicesNovoOrcamento(driver);

	}

	public ProfessionalServicesOrcamentosSolicitados enviarEmBranco() {

		WebElement btEnviar = driver.findElement(By.className("button-medium-text"));
		btEnviar.click();
		
		return new ProfessionalServicesOrcamentosSolicitados(driver);

	}

}
