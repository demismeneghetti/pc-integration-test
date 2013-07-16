package uoldiveo.painel.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.administracao.professionalservices.ProfessionalServicesNovoOrcamento;
import uoldiveo.painel.administracao.professionalservices.ProfessionalServicesOrcamentosSolicitados;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.home.login.LoginExternal;


public class AdministracaoProfessionalServiceSystemTest {

	private FirefoxDriver driver;
	private Home home;
	private LoginExternal login;
	private ProfessionalServicesNovoOrcamento psnop;
	private ProfessionalServicesOrcamentosSolicitados psosp;

	@Before
	public void inicializa() {

		driver = new FirefoxDriver();
		home = new Home(driver);
		login = new LoginExternal(driver);
		psnop = new ProfessionalServicesNovoOrcamento(driver);
		psosp = new ProfessionalServicesOrcamentosSolicitados(driver);

		home.acessa();
		login.loga("bobesponja@azul", "seja100%");

	}

	@Test
	public void listaOrcamentosSolicitados() {

		home.OrcamentosSolicitados();

		assertTrue(psosp.validaProfessionalServicesOrcamentosSolicitadosPage(
				"Orçamentos solicitados", "Novo orçamento", "Produto/Serviço:",
				"Data da solicitação:", "Status:", "Ver detalhes"));

	}

	@Test
	public void cancelaSolicitacaoNovoOrcamento() {

		home.OrcamentosSolicitados();
		
		psosp.novoOrcamento();

		psnop.cancelar();

		assertTrue(psosp
				.validaMensagem("Orçamentos solicitados"));

	}
	
	@Test
	public void enviaEmBrancoSolicitacaoNovoOrcamento() {

		home.OrcamentosSolicitados();
		
		psosp.novoOrcamento();

		psnop.enviarEmBranco();

		assertTrue(psosp
				.validaMensagem("Solicitar novo orçamento"));

	}

	@Test
	public void solicitaNovoOrcamentoTipo1() {

		home.OrcamentosSolicitados();
		
		psosp.novoOrcamento();

		psnop.solicita("Manutenção de Usuários", "");

		assertTrue(psosp
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	@Test
	public void solicitaNovoOrcamentoTipo2() {

		home.OrcamentosSolicitados();
		
		psosp.novoOrcamento();

		psnop.solicita("Execução de Migração para Nova Versão", "Descrição: Teste Automatizado Tipo 2");

		assertTrue(psosp
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	@Test
	public void solicitaNovoOrcamentoTipo3() {

		home.OrcamentosSolicitados();
		
		psosp.novoOrcamento();

		psnop.solicita("Instalação e Configuração - Máquina Virtual", "Descrição: Teste Automatizado Tipo 3");

		assertTrue(psosp
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	
	@After
	public void encerra() {
		driver.close();
	}
}
