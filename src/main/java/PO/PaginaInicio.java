package PO;

import org.openqa.selenium.WebDriver;

public class PaginaInicio extends BasePage{

    public PaginaInicio (WebDriver driver){
        super(driver);
    }
    String url ="https://www.google.cl";

    public void IngresoPagina(){
        driver.get(url);
    }
}
