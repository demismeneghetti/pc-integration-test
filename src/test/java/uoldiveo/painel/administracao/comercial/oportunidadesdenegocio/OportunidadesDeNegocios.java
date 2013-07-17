package uoldiveo.painel.administracao.comercial.oportunidadesdenegocio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	// Componente Contador
	// WebElement contadorDeOportunidades =
	// driver.findElement(By.className("sub-title fr"));
	// System.out.println(contadorDeOportunidades.getText());

	return new OportunidadesDeNegocios(driver);

    }

    // public OportunidadesDeNegocios listaTodas() {
    //
    // new lista(driver);
    //
    // cbOpo
    //
    // return new OportunidadesDeNegocios(driver);
    //
    // }

    // Select cbProdutoServico = new
    // Select(driver.findElement(By.id("idClassificationCall")));
    // WebElement txtDescricao = driver.findElement(By.id("call-infotext"));
    //
    // cbProdutoServico.selectByVisibleText(produtoservico);
    //
    // txtDescricao.sendKeys(descricao);
    // txtDescricao.submit();

    // public boolean validaProfessionalServicesOrcamentosSolicitados(String
    // title, String botao, String detalhePS, String detalheData,
    // String detalheStatus, String detalheLink) {
    //
    // return driver.getPageSource().contains(title) &&
    // driver.getPageSource().contains(botao)
    // && driver.getPageSource().contains(detalhePS) &&
    // driver.getPageSource().contains(detalheData)
    // && driver.getPageSource().contains(detalheStatus) &&
    // driver.getPageSource().contains(detalheLink);
    //
    // }

}
