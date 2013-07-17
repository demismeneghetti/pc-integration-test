package uoldiveo.painel.test.login;

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

public class LoginExternalTest {

    private FirefoxDriver driver;
    private LoginExternal login;
    private Home home;
    private LoginExternalSolicitaNovaSenha solicitaNovaSenha;
    private SolicitaNovaSenhaMensagens solicitaNovaSenhaMensagem;
    private static final Logger logger = Logger.getLogger(LoginExternalTest.class.getName());

    @Before
    public void inicializa() {

	logger.info("Abrindo navegador...");

	driver = new FirefoxDriver();
	home = new Home(driver);
	login = new LoginExternal(driver);
	solicitaNovaSenha = new LoginExternalSolicitaNovaSenha(driver);
	solicitaNovaSenhaMensagem = new SolicitaNovaSenhaMensagens(driver);

	home.acessa();

    }

    @Test
    public void loginComSucesso() {

	logger.info("Válido: Logando com sucesso...");

	login.loga("pedepano@azul", "seja100%");

	assertTrue(login.validaObrigatoriedadeSenha("Digite sua senha."));

    }

    @Test
    public void usuarioSenhaEmBranco() {

	logger.info("Inválido: Logando com usuário e senha em branco...");

	login.loga("", "");

	assertTrue(login.validaObrigatoriedadeLogin("Digite seu usuário."));
	assertTrue(login.validaObrigatoriedadeSenha("Digite sua senha."));

    }

    @Test
    public void usuarioEmBranco() {

	logger.info("Inválido: Logando com usuário em branco...");

	login.loga("", "seja100%");

	assertTrue(login.validaObrigatoriedadeLogin("Digite seu usuário."));

    }

    @Test
    public void senhaEmBranco() {

	logger.info("Inválido: Logando com senha em branco...");

	login.loga("pedepano@azul", "");

	assertTrue(login.validaObrigatoriedadeSenha("Digite sua senha."));

    }

    @Test
    public void solicitaNovaSenha() {

	logger.info("Válido: Validando página de solicitação de nova senha...");

	login.esqueciMinhaSenha();

	assertTrue(solicitaNovaSenhaMensagem.validaMensagemDeSucesso("Recuperação de senha"));

    }

    @After
    public void encerra() {

	logger.info("Fechando navegador...");

	driver.close();

    }
}
