package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

import javax.swing.*;

public class HomePage extends ClaseBase {
    //CENTRALIZAR LOCALIZADOR
    By localizadorSeguro = By.xpath("//p[contains(text(),'Somos Andes')]");
    By localizadorTrabajador = By.xpath("//p[contains(text(),'Trabajadores')]");
    By localizadorPensionados = By.xpath("//p[contains(text(),'Pensionados')]");
    By localizadorEmpresas = By.xpath("//p[contains(text(),'Empresas')]");

    By localizadorExafiliados = By.xpath("//p[contains(text(),'Ex afiliados')]");
    By localizadorSomosAndes = By.xpath("//h1[contains(text(),'Somos Andes')]");

    By localizadorFarmacia = By.xpath("//span[contains(text(),'Conoce tus beneficios en farmacia')]");

    By localizadorNovedades = By.xpath("//strong[contains(text(),'duran toda la vida')]");

    By localizadorEx = By.xpath("//a[contains(text(),'Conoce Sigo Siendo Andes')]");
    //Método que realicen las acciones del sitio
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void ir_a_SomosAndes() {

        click(esperarPorElementoAClickear(localizadorSeguro));

    }


    public void ir_a_Trabajadores() {
        click(esperarPorElementoAClickear(localizadorTrabajador));

    }

    public void ir_a_Pensionados() {
        click(esperarPorElementoAClickear(localizadorPensionados));
    }

    public void ir_a_ExAfiliados() {
        click(esperarPorElementoAClickear(localizadorExafiliados));
    }

    public void ir_a_Empresas() {
        click(esperarPorElementoAClickear(localizadorEmpresas));
    }


    public String getTitulo() {
        return obtenerTexto(esperarPresenciaWebElement(localizadorSomosAndes));
    }

    public String getFarmacia() {
        return obtenerTexto(esperarPresenciaWebElement(localizadorFarmacia));
    }
    public String getNovedades() {
        return obtenerTexto(esperarPresenciaWebElement(localizadorNovedades));
    }
    public String getExAf() {
        return obtenerTexto(esperarPresenciaWebElement(localizadorEx));
    }
}
