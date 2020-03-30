import PO.BasePage;
import PO.PaginaInicio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Test.testMethods.takeSnapShot;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_01 {

    String log4jConfPath = "./src/test/resources/log4j.properties";
    WebDriver driver;
    PaginaInicio pagini;
    BasePage base;

    @BeforeAll
    public void SetUp() {

        PropertyConfigurator.configure(log4jConfPath);
        System.setProperty("java.net.useSystemProxies", "true");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        this.pagini = new PaginaInicio(driver);
        this.base = new BasePage(driver);
    }
    @AfterAll
    public void tear(){
        driver.close();
    }

    @AfterEach
    public void afterEach(TestInfo testinfo) throws Exception {
        takeSnapShot(this.driver, this.getClass().getName()+"-"+testinfo.getDisplayName());
    }

    @Test
    @Order(1)
    public void Paso1() {
        base.Log("Se inicia prueba");
        pagini.IngresoPagina();
    }


}
