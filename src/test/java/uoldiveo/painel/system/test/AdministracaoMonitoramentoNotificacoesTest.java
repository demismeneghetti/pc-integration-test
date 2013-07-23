package uoldiveo.painel.system.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.administracao.monitoramento.notificacoes.Notificacoes;
import uoldiveo.painel.administracao.monitoramento.notificacoes.NotificacoesNovaNotificacao;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;

public class AdministracaoMonitoramentoNotificacoesTest {

    private FirefoxDriver driver;
    private Home home;
    private LoginExternal login;
    private Notificacoes nn;
    private NotificacoesNovaNotificacao nnn;

    @Before
    public void inicializa() {

	driver = new FirefoxDriver();
	home = new Home(driver);
	login = new LoginExternal(driver);
	nn = new Notificacoes(driver);
	nnn = new NotificacoesNovaNotificacao(driver);

	home.acessaExternal();
	login.loga("bobesponja@azul", "seja100%");

    }

    @Test
    public void criaNotificacao() {

	home.Notificacoes();

	nn.novaRegra();

	nnn.insereTituloDaNotificacao("Automação de Teste - Cria Notificação");
	nnn.insereDetalhesDaNotificacao("Teste Automatizado");
	nnn.selecionaItensMonitorados(0);
	nnn.selecionaItensMonitorados(1);
	nnn.selecionaItensMonitorados(2);

	nnn.selecionaContatos(0);
	nnn.selecionaTipoNotificacaoEmail(0);
	// nnn.selecionaTipoNotificacaoSMS(0);

	nnn.criarNotificacao();

	assertTrue(nnn.validaMensagem("A notificação [Automação de Teste - Cria Notificação] foi criada com sucesso."));

    }

    @Test
    public void removeNotificacaoFechaModal() {

	home.Notificacoes();

	nn.removerRegra();
	
	nn.removerRegraModalFechar();

    }
    
    @Test
    public void removeNotificacaoCancelaRemocao() {

	home.Notificacoes();

	nn.novaRegra();

	nnn.insereTituloDaNotificacao("Automação de Teste - Cria Notificação");
	nnn.insereDetalhesDaNotificacao("Teste Automatizado");
	nnn.selecionaItensMonitorados(0);
	nnn.selecionaContatos(0);
	nnn.selecionaTipoNotificacaoEmail(0);
	nnn.criarNotificacao();
	
	nn.removerRegra();
	
	nn.removerRegraModalCancelar();

    }

    @Test
    public void removeNotificacaoConfirmaRemocao() {

	home.Notificacoes();

	nn.removerRegra();

	assertTrue(nn.removerRegraModalValidaTexto("Exclusão de notificação", "Confirma a exclusão da notificação",
		"Automação de Teste - Cria Notificação"));

	nn.removerRegraModalConfirmar();

    }

    @After
    public void encerra() {
	driver.close();
    }

}
