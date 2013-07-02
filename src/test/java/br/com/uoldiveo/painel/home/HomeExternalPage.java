package br.com.uoldiveo.painel.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeExternalPage {

	private WebDriver driver;

	public HomeExternalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void acessa() {
		driver.get("https://painel.uoldiveo.com.br");
	}

	public void OrcamentosSolicitados() {
		WebElement clickOrcamentosSolicitados = driver.findElement(By
				.linkText("Orçamentos solicitados"));
		clickOrcamentosSolicitados.click();
	}

	public void NovoOrcamento() {
		WebElement clickNovoOrcamento = driver.findElement(By
				.linkText("Novo orçamento"));
		clickNovoOrcamento.click();
	}

}
