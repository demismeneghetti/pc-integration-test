package br.com.uoldiveo.painel.home.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.uoldiveo.painel.testes.SolicitaNovaSenhaMensagensPage;

public class LoginExternalSolicitaNovaSenhaPage {

	private WebDriver driver;

	public LoginExternalSolicitaNovaSenhaPage(WebDriver driver) {

		this.driver = driver;

	}

	public SolicitaNovaSenhaMensagensPage solicitaNovaSenha(String usuario, String email) {

		WebElement txtUsuario = driver.findElement(By.id("username"));
		WebElement txtEmail = driver.findElement(By.id("email"));

		txtUsuario.sendKeys(usuario);
		txtEmail.sendKeys(email);

		txtEmail.submit();
		
		return new SolicitaNovaSenhaMensagensPage(driver);

	}

}
