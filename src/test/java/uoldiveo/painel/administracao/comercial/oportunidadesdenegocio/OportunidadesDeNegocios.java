package uoldiveo.painel.administracao.comercial.oportunidadesdenegocio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OportunidadesDeNegocios {

    private WebDriver driver;

    public OportunidadesDeNegocios(WebDriver driver) {

	this.driver = driver;

    }

    public OportunidadesDeNegocios lista(String oportunidade, String LinhaDeNegocio) {

	// Combo-box Oportunidades
	Select cbOportunidade = new Select(driver.findElement(By.id("opportunityStatus")));
	cbOportunidade.selectByVisibleText(oportunidade);

	// Combo-box Linha de Negócio
	Select cbLinhaDeNegocio = new Select(driver.findElement(By.id("lineOfBusiness")));
	cbLinhaDeNegocio.selectByVisibleText(LinhaDeNegocio);

	return new OportunidadesDeNegocios(driver);

    }

}
