package uoldiveo.painel.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginExternalSolicitaNovaSenha {

    private WebDriver driver;

    public LoginExternalSolicitaNovaSenha(WebDriver driver) {

	this.driver = driver;

    }

    public SolicitaNovaSenhaMensagens solicitaNovaSenha(String usuario, String email) {

	WebElement txtUsuario = driver.findElement(By.id("username"));
	WebElement txtEmail = driver.findElement(By.id("email"));
	WebElement btEnviar = driver.findElement(By.className("button-text"));

	txtUsuario.sendKeys(usuario);
	txtEmail.sendKeys(email);

	btEnviar.click();

	return new SolicitaNovaSenhaMensagens(driver);

    }

}
