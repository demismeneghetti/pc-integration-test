package uoldiveo.painel.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginSolicitaNovaSenha {

	private WebDriver driver;

	public LoginSolicitaNovaSenha(WebDriver driver) {

		this.driver = driver;

	}

	public SolicitaNovaSenhaMensagens solicitaNovaSenha(String usuario, String email) {

		WebElement txtUsuario = driver.findElement(By.id("username"));
		WebElement txtEmail = driver.findElement(By.id("email"));

		txtUsuario.sendKeys(usuario);
		txtEmail.sendKeys(email);

		txtEmail.submit();
		
		return new SolicitaNovaSenhaMensagens(driver);

	}

}
