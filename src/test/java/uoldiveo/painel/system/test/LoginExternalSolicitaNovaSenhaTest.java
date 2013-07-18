package uoldiveo.painel.system.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;
import uoldiveo.painel.login.LoginExternalSolicitaNovaSenha;
import uoldiveo.painel.login.SolicitaNovaSenhaMensagens;

public class LoginExternalSolicitaNovaSenhaTest {

    private FirefoxDriver driver;
    private LoginExternal login;
    private Home home;
    private LoginExternalSolicitaNovaSenha solicitaNovaSenha;
    private SolicitaNovaSenhaMensagens solicitaNovaSenhaMensagem;
    private static final Logger logger = Logger.getLogger(LoginExternalSolicitaNovaSenhaTest.class.getName());

    @Before
    public void inicializa() {

	logger.info("Abrindo navegador...");

	driver = new FirefoxDriver();
	home = new Home(driver);
	login = new LoginExternal(driver);
	solicitaNovaSenha = new LoginExternalSolicitaNovaSenha(driver);
	solicitaNovaSenhaMensagem = new SolicitaNovaSenhaMensagens(driver);

	home.acessaExternal();

    }

    @Test
    public void usuarioEEmailEmBranco() {

	logger.info("Inválido: Solicitando nova senha sem preencher usuário e senha...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("", "");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu usuário cadastrado no portal."));
	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu e-mail cadastrado no portal."));

    }

    @Test
    public void usuarioEmBranco() {

	logger.info("Inválido: Solicitando nova senha preenchendo usuário em branco e senha válida...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("", "teste-painel@bol.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu usuário cadastrado no portal."));

    }

    @Test
    public void emailEmBranco() {

	logger.info("Inválido: Solicitando nova senha preenchendo usuário válido e senha em branco...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("bobesponja@azul", "");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu e-mail cadastrado no portal."));

    }

    @Test
    public void usuarioInvalidoEmailEmBranco() {

	logger.info("Inválido: Solicitando nova senha preenchendo usuário inválido e email em branco...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("usuario@invalido", "");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu e-mail cadastrado no portal."));

    }

    @Test
    public void emailInvalidoUsuarioEmBranco() {

	logger.info("Inválido: Solicitando nova senha preenchendo usuário em branco e senha inválida...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("", "email@invalido.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Informe seu usuário cadastrado no portal."));

    }
    
    @Test
    public void emailESenhaInvalidos() {

	logger.info("Inválido: Solicitando nova senha com usuário e senha inválidos...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("usuario@invalido", "email@invalido.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Usuário não encontrado"));

    }

    @Test
    public void emailInvalido() {

	logger.info("Válido: Solicitando nova senha com email inválido...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("bobesponja@azul", "email@invalido.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("E-mail de confirmação inválido"));

    }

    @Test
    public void usuarioInvalido() {

	logger.info("Válido: Solicitando nova senha com usuário inválido...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("usuario@invalido", "teste-painel@bol.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Usuário não encontrado"));

    }

    @Test
    public void solicitaNovaSenha() {

	logger.info("Válido: Solicitando nova senha...");

	login.esqueciMinhaSenha();

	solicitaNovaSenha.solicitaNovaSenha("bobesponja@azul", "teste-painel@bol.com.br");

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Sua senha foi enviada para teste-painel@bol.com.br"));

    }

    @After
    public void encerra() {

	logger.info("Fechando navegador...");

	driver.close();

    }
}
