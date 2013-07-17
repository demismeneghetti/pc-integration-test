package uoldiveo.painel.system.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import uoldiveo.painel.administracao.comercial.oportunidadesdenegocio.OportunidadesDeNegocios;
import uoldiveo.painel.home.Home;
import uoldiveo.painel.login.LoginExternal;

public class AdministracaoComercialOportunidadeDeNegociosSystemTest {

    private FirefoxDriver driver;
    private Home home;
    private LoginExternal login;
    private OportunidadesDeNegocios odn;

    @Before
    public void inicializa() {

	driver = new FirefoxDriver();
	home = new Home(driver);
	login = new LoginExternal(driver);
	odn = new OportunidadesDeNegocios(driver);

	home.acessa();
	login.loga("bobesponja@azul", "seja100%");

    }

    @Test
    public void listaTodos() {

	home.OportunidadesDeNegocios();

    }

    @Test
    public void listaEmAndamento() {

	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Todas");

    }

    @Test
    public void listaEmAndamentoDataCenter() {

	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Data Center");

    }

    @Test
    public void listaEmAndamentoTelecom() {

	home.OportunidadesDeNegocios();
	odn.lista("Em Andamento", "Telecom");

    }

    @Test
    public void listaFechadas() {

	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Todas");

    }

    @Test
    public void listaFechadasDataCenter() {

	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Data Center");

    }

    @Test
    public void listaFechadasTelecom() {

	home.OportunidadesDeNegocios();
	odn.lista("Fechada", "Telecom");

    }

    @After
    public void close() {

	driver.close();

    }

}
