package br.com.uoldiveo.painel.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.uoldiveo.painel.HomeExternalPage;
import br.com.uoldiveo.painel.LoginExternalPage;
import br.com.uoldiveo.painel.administracao.professional.services.ProfessionalServicesNovoOrcamentoPage;
import br.com.uoldiveo.painel.administracao.professional.services.ProfessionalServicesOrcamentosSolicitadosPage;

public class ProfessionalServiceSystemTest {

	private FirefoxDriver driver;
	private HomeExternalPage home;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();
		home = new HomeExternalPage(driver);
		
		home.acessa();
		LoginExternalPage login = new LoginExternalPage(driver);
		login.loga("pedepano@azul", "seja100%");
	}
	
	@Test
	public void acessaOrcamentosSolicitados(){
		ProfessionalServicesOrcamentosSolicitadosPage orcamentosSolicitados = new ProfessionalServicesOrcamentosSolicitadosPage(driver);
		// Implementar a verificação do conteúdo na tela.
		orcamentosSolicitados.novoOrcamento();
	}
	
	@Test
	public void solicitaNovoOrcamento(){
		ProfessionalServicesNovoOrcamentoPage novoOrcamento = new ProfessionalServicesNovoOrcamentoPage(driver);
		novoOrcamento.solicita();
	}
	
//	@After
//	public void encerra() {
//		driver.close();
//	}

}
