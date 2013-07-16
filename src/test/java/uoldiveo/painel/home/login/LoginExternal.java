package uoldiveo.painel.home.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginExternal {

	private WebDriver driver;

	public LoginExternal(WebDriver driver) {

		this.driver = driver;

	}

	public void loga(String usuario, String senha) {

		WebElement txtUsuario = driver.findElement(By.id("username"));
		WebElement txtSenha = driver.findElement(By.id("password"));

		txtUsuario.sendKeys(usuario);
		txtSenha.sendKeys(senha);

		txtSenha.submit();

	}

	public boolean validaObrigatoriedadeLogin(String mensagemErrologin) {

		return driver.getPageSource().contains(mensagemErrologin);

	}

	public boolean validaObrigatoriedadeSenha(String mensagemErroSenha) {

		return driver.getPageSource().contains(mensagemErroSenha);

	}

	public void esqueciMinhaSenha() {

		WebElement txtEsqueciMinhaSenha = driver.findElement(By
				.linkText("Esqueci minha senha"));
		
		txtEsqueciMinhaSenha.click();
		
	}
	
}
