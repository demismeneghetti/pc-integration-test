package br.com.uoldiveo.painel.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesNovoOrcamentoPage;
import br.com.uoldiveo.painel.home.HomeExternalPage;
import br.com.uoldiveo.painel.home.login.LoginExternalPage;

public class AdministracaoProfessionalServiceSystemTest {

	private FirefoxDriver driver;
	private HomeExternalPage home;
	private LoginExternalPage login;
	private ProfessionalServicesNovoOrcamentoPage psno;

	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		home = new HomeExternalPage(driver);
		login = new LoginExternalPage(driver);
		psno = new ProfessionalServicesNovoOrcamentoPage(driver);
		
		home.acessa();
		login.loga("pedepano@azul", "seja100%");
		
	}

	@Test
	public void listaOrcamentosSolicitados() {

		home.OrcamentosSolicitados();
		
		// Implementar checagem da tela!

	}

	@Test
	public void solicitaNovoOrcamento() {

		home.NovoOrcamento();
		psno.solicita("Manutenção de Usuários", "Descrição: Teste Automatizado");

		// Implementar validação da mensagem de sucesso!

	}

	@After
	public void encerra() {
		driver.close();
	}

}
