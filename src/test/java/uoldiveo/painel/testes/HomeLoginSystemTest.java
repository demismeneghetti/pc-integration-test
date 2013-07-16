package uoldiveo.painel.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.home.Home;
import uoldiveo.painel.home.login.LoginExternal;
import uoldiveo.painel.home.login.LoginSolicitaNovaSenha;
import uoldiveo.painel.home.login.SolicitaNovaSenhaMensagens;


public class HomeLoginSystemTest {

	private FirefoxDriver driver;
	private LoginExternal login;
	private Home home;
	private LoginSolicitaNovaSenha solicitaNovaSenha;
	private SolicitaNovaSenhaMensagens solicitaNovaSenhaMensagem;
	
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		home = new Home(driver);
		login = new LoginExternal(driver);
		solicitaNovaSenha = new LoginSolicitaNovaSenha(driver);
		solicitaNovaSenhaMensagem = new SolicitaNovaSenhaMensagens(driver);
		
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
