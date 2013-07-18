package uoldiveo.painel.system.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServicesNovoOrcamento;
import uoldiveo.painel.administracao.comercial.professionalservices.ProfessionalServices;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;

public class AdministracaoComercialProfessionalServiceTest {

    private FirefoxDriver driver;
    private Home home;
    private LoginExternal login;
    private ProfessionalServicesNovoOrcamento psno;
    private ProfessionalServices psos;

    @Before
    public void inicializa() {

	driver = new FirefoxDriver();
	home = new Home(driver);
	login = new LoginExternal(driver);
	psno = new ProfessionalServicesNovoOrcamento(driver);
	psos = new ProfessionalServices(driver);

	home.acessaExternal();
	login.loga("bobesponja@azul", "seja100%");

    }

    @Test
    public void listaOrcamentosSolicitados() {

	home.ProfessionalServices();

	assertTrue(psos.validaProfessionalServicesOrcamentosSolicitados("Professional services", "Novo orçamento", "Produto/Serviço:",
		"Data da solicitação:", "Status:", "Ver detalhes"));

    }

    @Test
    public void cancelaSolicitacaoNovoOrcamento() {

	home.ProfessionalServices();

	psos.novoOrcamento();

	psno.cancelar();

	assertTrue(psos.validaMensagem("Professional services"));

    }

    @Test
    public void enviaEmBrancoSolicitacaoNovoOrcamento() {

	home.ProfessionalServices();

	psos.novoOrcamento();

	psno.solicita("Selecione um Produto/Serviço", "");

	assertTrue(psos.validaMensagem("Solicitar novo orçamento"));

    }

    @Test
    public void solicitaNovoOrcamentoTipo1() {

	home.ProfessionalServices();

	psos.novoOrcamento();

	psno.solicita("Manutenção de Usuários", "");

	assertTrue(psos.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

    }

    @Test
    public void solicitaNovoOrcamentoTipo2() {

	home.ProfessionalServices();

	psos.novoOrcamento();

	psno.solicita("Execução de Migração para Nova Versão", "Descrição: Teste Automatizado Tipo 2");

	assertTrue(psos.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

    }

    @Test
    public void solicitaNovoOrcamentoTipo3() {

	home.ProfessionalServices();

	psos.novoOrcamento();

	psno.solicita("Instalação e Configuração - Máquina Virtual", "Descrição: Teste Automatizado Tipo 3");

	assertTrue(psos.validaMensagem("A solicitação de orçamento foi enviada com sucesso."));

    }

    @After
    public void encerra() {
	driver.close();
    }
}
