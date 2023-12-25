package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class Trabajadores extends ClaseBase {
//Centralizar los By
    By localizadorBeneficios = By.xpath("//span[contains(text(),'Beneficios para ti')]");
    By localizadorSalud = By.xpath("//span[contains(text(),'Salud')]");
    public Trabajadores(WebDriver driver) {
        super(driver);
    }
public void obtenerBeneficios(){
    if(estaDesplegado(esperarPresenciaWebElement(localizadorBeneficios))){
        click(localizadorBeneficios);
    }

}
    public String getSalud() {
        return obtenerTexto( esperarPresenciaWebElement(localizadorSalud));
    }

}
