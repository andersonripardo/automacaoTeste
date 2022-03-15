package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "andersonripardo_JTPZ9u";
    public static final String AUTOMATE_KEY = "zF6gpKy1rPthemggRV1A";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public static WebDriver createChrome(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anderson_maciel\\Documents\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a pagina do taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Thread 1");

        WebDriver navegador = null;

                try {
                    navegador = new RemoteWebDriver(new URL(URL), caps);
                    navegador.manage().window().maximize();
                    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a pagina do taskit
                    navegador.get("http://www.juliodelima.com.br/taskit");
                }catch(MalformedURLException e){
                    System.out.println("Houveram problemas com URL" + e.getMessage());
                }


        return navegador;
    }
}
