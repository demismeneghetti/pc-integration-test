package uoldiveo.painel.system.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesNovoOrcamento;
import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesOrcamentosSolicitados;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;


public class AdministracaoComercialProfessionalServiceSystemTest {

	private FirefoxDriver driver;
	private Home home;
	private LoginExternal login;
	private ProfessionalServicesNovoOrcamento psno;
	private ProfessionalServicesOrcamentosSolicitados psos;

	@Before
	public void inicializa() {

		driver = new FirefoxDriver();
		home = new Home(driver);
		login = new LoginExternal(driver);
		psno = new ProfessionalServicesNovoOrcamento(driver);
		psos = new ProfessionalServicesOrcamentosSolicitados(driver);

		home.acessa();
		login.loga("bobesponja@azul", "seja100%");

	}

	@Test
	public void listaOrcamentosSolicitados() {

		home.OrcamentosSolicitados();

		assertTrue(psos.validaProfessionalServicesOrcamentosSolicitados(
				"Orçamentos solicitados", "Novo orçamento", "Produto/Serviço:",
				"Data da solicitação:", "Status:", "Ver detalhes"));

	}

	@Test
	public void cancelaSolicitacaoNovoOrcamento() {

		home.OrcamentosSolicitados();
		
		psos.novoOrcamento();

		psno.cancelar();

		assertTrue(psos.validaMensagem("Orçamentos solicitados"));

	}
	
	@Test
	public void enviaEmBrancoSolicitacaoNovoOrcamento() {

		home.OrcamentosSolicitados();
		
		psos.novoOrcamento();

		psno.enviarEmBranco();

		assertTrue(psos
				.validaMensagem("Solicitar novo orçamento"));

	}

	@Test
	public void solicitaNovoOrcamentoTipo1() {

		home.OrcamentosSolicitados();
		
		psos.novoOrcamento();

		psno.solicita("Manutenção de Usuários", "");

		assertTrue(psos
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	@Test
	public void solicitaNovoOrcamentoTipo2() {

		home.OrcamentosSolicitados();
		
		psos.novoOrcamento();

		psno.solicita("Execução de Migração para Nova Versão", "Descrição: Teste Automatizado Tipo 2");

		assertTrue(psos
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	@Test
	public void solicitaNovoOrcamentoTipo3() {

		home.OrcamentosSolicitados();
		
		psos.novoOrcamento();

		psno.solicita("Instalação e Configuração - Máquina Virtual", "Descrição: Teste Automatizado Tipo 3");

		assertTrue(psos
				.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

	}

	
	@After
	public void encerra() {
		driver.close();
	}
}
