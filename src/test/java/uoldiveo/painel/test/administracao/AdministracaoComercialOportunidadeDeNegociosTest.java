package uoldiveo.painel.test.administracao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;


import uoldiveo.painel.administracao.comercial.oportunidadesdenegocio.OportunidadesDeNegocios;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;

public class AdministracaoComercialOportunidadeDeNegociosTest {

    private FirefoxDriver driver;
    private Home home;
    private LoginExternal login;
    private OportunidadesDeNegocios odn;
    private static final Logger logger = Logger.getLogger(AdministracaoComercialOportunidadeDeNegociosTest.class.getName());

    @Before
    public void inicializa() {

	driver = new FirefoxDriver();

	home = new Home(driver);
	home.acessa();
	
	login = new LoginExternal(driver);
	login.loga("bobesponja@azul", "seja100%");

	logger.info("Carregando página [Oportunidade de negócios]...");
	odn = new OportunidadesDeNegocios(driver);

    }

    @Test
    public void listaTodasTodas() {

	logger.info("Selecionando [Status: 'Todas'] e [Linha de negócio: 'Todas']");
	home.OportunidadesDeNegocios();
	odn.lista("Todas", "Todas");

    }
    
    @Test
    public void listaTodasDataCenter() {

	logger.info("Selecionando [Status: 'Todas'] e [Linha de negócio: 'Data Center']");
	home.OportunidadesDeNegocios();
	odn.lista("Todas", "Todas");

    }
    
    @Test
    public void listaTodasTelecom() {

	logger.info("Selecionando [Status: 'Todas'] e [Linha de negócio: 'Telecom']");
	home.OportunidadesDeNegocios();
	odn.lista("Todas", "Todas");

    }

    @Test
    public void listaEmAndamento() {

	logger.info("Selecionando [Status: 'Em Andamento'] e [Linha de negócio: 'Todas']");
	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Todas");

    }

    @Test
    public void listaEmAndamentoDataCenter() {

	logger.info("Selecionando [Status: 'Em Andamento'] e [Linha de negócio: 'Data Center']");
	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Data Center");

    }

    @Test
    public void listaEmAndamentoTelecom() {

	logger.info("Selecionando [Status: 'Em Andamento'] e [Linha de negócio: 'Telecon']");
	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Telecom");

    }

    @Test
    public void listaFechadas() {
	
	logger.info("Selecionando [Status: 'Fechada'] e [Linha de negócio: 'Todas']");
	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Todas");

    }

    @Test
    public void listaFechadasDataCenter() {

	logger.info("Selecionando [Status: 'Fechada'] e [Linha de negócio: 'Data Center']");
	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Data Center");

    }

    @Test
    public void listaFechadasTelecom() {

	logger.info("Selecionando [Status: 'Fechada'] e [Linha de negócio: 'Telecom']");
	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Telecom");

    }

    @After
    public void close() {

	driver.close();

    }

}
