package uoldiveo.painel.administracao.comercial.professionalservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalServicesNovoOrcamento {

    private WebDriver driver;

    public ProfessionalServicesNovoOrcamento(WebDriver driver) {

	this.driver = driver;

    }

    public ProfessionalServices solicita(String produtoservico, String descricao) {

	Select cbProdutoServico = new Select(driver.findElement(By.id("idClassificationCall")));
	WebElement txtDescricao = driver.findElement(By.id("call-infotext"));
	WebElement btEnviar = driver.findElement(By.className("button-medium-text"));

	cbProdutoServico.selectByVisibleText(produtoservico);

	txtDescricao.sendKeys(descricao);
	btEnviar.click();

	return new ProfessionalServices(driver);

    }

    public ProfessionalServicesNovoOrcamento cancelar() {

	WebElement btCancelar = driver.findElement(By.className("cancelNewProfessionalService"));
	btCancelar.click();

	return new ProfessionalServicesNovoOrcamento(driver);

    }

}
