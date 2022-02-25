package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.text.BreakIterator;
import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;
    @Before
    public void setUp(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anderson_maciel\\Documents\\drivers\\chromedriver_win32\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Navegando para a pagina do taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto Sign in
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Identificar formalurio de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name login dentro do formulario de id "singinbox" o texto "anderson002"
        formularioSignInBox.findElement(By.name("login")).sendKeys("anderson002");

        //Digitar no campo com name password dentro do formulario de id "singinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar no link com class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar no link com texto "More data about you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão atraves do Xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde esta o "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No campo de name "contat" inserir +859123456789
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+859123456789");

        //Clicar no link de text "Save" que esta no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto "Your contact has been added!"
        WebElement mesnagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mesnagemPop.getText();
        assertEquals("\"Your contact has been added!\"", mensagem);
    }

        @After
       public void tearDown() {
            //Fechar navegador
            //navegador.close();
    }
}
