package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

public class informacoesUusarioPageObjectsTest {
    private WebDriver navegador;
    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("anderson002","123456")
                .clicarMe();
    }

    @After
    public  void tearDown(){
        navegador.quit();
    }
}
