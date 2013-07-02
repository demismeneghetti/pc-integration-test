package br.com.uoldiveo.painel.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesNovoOrcamentoPage;
import br.com.uoldiveo.painel.administracao.professionalservices.ProfessionalServicesOrcamentosSolicitadosPage;
import br.com.uoldiveo.painel.home.HomeExternalPage;
import br.com.uoldiveo.painel.home.login.LoginExternalPage;

public class AdministracaoProfessionalServiceSystemTest {

	private FirefoxDriver driver;
	private HomeExternalPage home;
	private LoginExternalPage login;
	private ProfessionalServicesNovoOrcamentoPage psno;
	private ProfessionalServicesOrcamentosSolicitadosPage psosp;

	@Before
	public void inicializa() {

		driver = new FirefoxDriver();
		home = new HomeExternalPage(driver);
		login = new LoginExternalPage(driver);
		psno = new ProfessionalServicesNovoOrcamentoPage(driver);
		psosp = new ProfessionalServicesOrcamentosSolicitadosPage(driver);

		home.acessa();
		login.loga("pedepano@azul", "seja100%");

	}

	@Test
	public void listaOrcamentosSolicitados() {

		home.OrcamentosSolicitados();

		assertTrue(psosp.validaProfessionalServicesOrcamentosSolicitadosPage(
				"Orçamentos solicitados", "Novo orçamento", "Protudo/Serviço:",
				"Data da solicitação:", "Status:", "Ver detalhes"));

	}

	@Test
	public void solicitaNovoOrcamento() {

		home.NovoOrcamento();

		psno.solicita("Manutenção de Usuários", "Descrição: Teste Automatizado");

		assertTrue(psosp
				.validaNovoOrcamentoMensagemDeSucesso("A solicitação de orçamento foi enviada com sucesso."));

	}

//	@After
//	public void encerra() {
//		driver.close();
//	}

}
