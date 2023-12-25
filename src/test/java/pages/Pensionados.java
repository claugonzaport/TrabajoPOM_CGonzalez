package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class Pensionados extends ClaseBase {
    //Centralizar los By
    By localizadorBeneficiosFarmacia = By.xpath("//span[contains(text(),'Conoce tus beneficios en farmacia')]");
    public Pensionados(WebDriver driver) {
        super(driver);
    }
    public void siguiente(){
        esperarXSegundos(5000);
        click(localizadorBeneficiosFarmacia);
    }
    public void obtenerBeneficiosFar(){
        siguiente();
        if(estaDesplegado(esperarPresenciaWebElement(localizadorBeneficiosFarmacia))){
            click(localizadorBeneficiosFarmacia);
        }



    }
}
