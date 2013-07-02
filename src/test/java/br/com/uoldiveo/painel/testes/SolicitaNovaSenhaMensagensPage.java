package br.com.uoldiveo.painel.testes;

import org.openqa.selenium.WebDriver;

public class SolicitaNovaSenhaMensagensPage {

	private WebDriver driver;

	public SolicitaNovaSenhaMensagensPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public boolean validaMensagemDeSucesso(String mensagemDeSucesso) {

		return driver.getPageSource().contains(mensagemDeSucesso);

	}

}
