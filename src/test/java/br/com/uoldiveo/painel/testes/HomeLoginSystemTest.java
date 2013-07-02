package br.com.uoldiveo.painel.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.uoldiveo.painel.home.HomeExternalPage;
import br.com.uoldiveo.painel.home.login.LoginExternalPage;
import br.com.uoldiveo.painel.home.login.LoginExternalSolicitaNovaSenhaPage;

public class HomeLoginSystemTest {

	private FirefoxDriver driver;
	private LoginExternalPage login;
	private HomeExternalPage home;
	private LoginExternalSolicitaNovaSenhaPage solicitaNovaSenha;
	private SolicitaNovaSenhaMensagensPage solicitaNovaSenhaMensagem;
	
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		home = new HomeExternalPage(driver);
		login = new LoginExternalPage(driver);
		solicitaNovaSenha = new LoginExternalSolicitaNovaSenhaPage(driver);
		solicitaNovaSenhaMensagem = new SolicitaNovaSenhaMensagensPage(driver);
		
		home.acessa();
	
	}

	@Test
	public void usuarioSenhaEmBranco() {
		
		login.loga("", "");
		assertTrue(login.validaObrigatoriedadeLogin("Digite seu usuário."));
		assertTrue(login.validaObrigatoriedadeSenha("Digite sua senha."));
	
	}

	@Test
	public void usuarioEmBranco() {
	
		login.loga("", "seja100%");
		assertTrue(login.validaObrigatoriedadeLogin("Digite seu usuário."));
	
	}

	@Test
	public void senhaEmBranco() {
	
		login.loga("pedepano@azul", "");
		assertTrue(login.validaObrigatoriedadeSenha("Digite sua senha."));
	
	}
	
	@Test
	public void solicitaNovaSenha(){
	
		login.esqueciMinhaSenha();
		
		solicitaNovaSenha.solicitaNovaSenha("bobesponja@azul", "teste-painel@bol.com.br");
		
		assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Sua senha foi enviada para teste-painel@bol.com.br"));
	
	}

	@After
	public void encerra() {
	
		driver.close();
	
	}
}
