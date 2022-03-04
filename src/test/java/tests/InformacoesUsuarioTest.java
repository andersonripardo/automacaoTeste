package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioTestData.csv")

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        navegador = Web.createChrome();

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
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato,
     @Param(name="mensagem")String mensagemEsperada
    ) {

        //Clicar no botão atraves do Xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde esta o "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name "contat" inserir +859123456789
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Clicar no link de text "Save" que esta no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto "Your contact has been added!"
        WebElement mesnagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mesnagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);

        /*String screenshotArquivo = "C:\\Users\\anderson_maciel\\Desktop\\Estudo_Selenium_WEBDriver\\src\\screenshot\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);*/
    }

    @Test
    public void removerContatoDeUmUsuario(){
        // Clicar no elemento pelo seu xpath //span[text()="+859123456789"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+859123456789\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);

        String screenshotArquivo = "C:\\Users\\anderson_maciel\\Desktop\\Estudo_Selenium_WEBDriver\\src\\screenshot\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //aguardar até 10 segundos para que a janela desapareca
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Clicar no link com texto logout
        navegador.findElement(By.linkText("Logout")).click();
    }
        @After
       public void tearDown() {
            //Fechar navegador
            navegador.close();
    }
}
