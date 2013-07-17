package uoldiveo.painel.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uoldiveo.painel.administracao.comercial.oportunidadesdenegocio.OportunidadesDeNegocios;
import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServices;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
	this.driver = driver;
    }

    public void acessa() {
	driver.get("https://painel.uoldiveo.com.br");
    }

    // ADMINISTRACAO
    // // COMERCIAL
    // //// PROFESSIONAL SERVICES
    public ProfessionalServices ProfessionalServices() {
	WebElement clickOrcamentosSolicitados = driver.findElement(By.linkText("Professional services"));

	clickOrcamentosSolicitados.click();

	return new ProfessionalServices(driver);
    }

    // //// OPORTUNIDADES DE NEGOCIOS
    public OportunidadesDeNegocios OportunidadesDeNegocios() {
	WebElement clickOportunidadesDeNegocios = driver.findElement(By.linkText("Oportunidades de negócios"));

	clickOportunidadesDeNegocios.click();

	return new OportunidadesDeNegocios(driver);
    }

}
