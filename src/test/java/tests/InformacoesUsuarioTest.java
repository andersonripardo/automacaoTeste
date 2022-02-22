package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anderson_maciel\\Documents\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        //Navegando para a pagina do taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto sing in

        //Clicar no campo com name login que esta dentro do formaluario de Id= "singinbox"

        //Digitar no campo com name login dentro do formulario de id "singinbox" o texto "anderson002"

        //Clicar no campo com name passsword que esta dentro do formaluario de Id= "singinbox"

        //Digitar no campo com name password dentro do formulario de id "singinbox" o texto "123456"

        //Digitar no link com o texto SIGN IN

        //Validar que dentro do elemento com class "me" esta o texto "Hi, nomeUsuario"

        //Fechar navegador



        //Validação do navegador
        assertEquals(1, 1);
    }
}
