package uoldiveo.painel.login;

import org.openqa.selenium.WebDriver;

public class SolicitaNovaSenhaMensagens {

    private WebDriver driver;

    public SolicitaNovaSenhaMensagens(WebDriver driver) {

	this.driver = driver;

    }

    public boolean validaMensagemDeSucesso(String mensagemDeSucesso) {

	return driver.getPageSource().contains(mensagemDeSucesso);

    }

}
