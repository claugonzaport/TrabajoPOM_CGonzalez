package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.Pensionados;
import pages.Trabajadores;
import utils.DataDriven;
import utils.PropertiesManager;

import java.util.ArrayList;

public class CasosDePrueba {
    private WebDriver driver; //null
    private HomePage homePage;
    private Trabajadores trabajadores;
    private Pensionados pensionados;
    private String browser = PropertiesManager.obtenerProperty("browser");
    private String propertyDriver =PropertiesManager.obtenerProperty("propertyDriver");
    private String rutaDriver =PropertiesManager.obtenerProperty("rutaDriver");
    private String url =PropertiesManager.obtenerProperty("url");
    private ArrayList<String> datosPrueba; //null
    @BeforeEach
    public void preparacionTests(){
        datosPrueba = new ArrayList<String>(); //arreglo tamaño 0
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        homePage.manejoEsperasElementosWeb(10);
        trabajadores = new Trabajadores(homePage.getDriver());
        pensionados = new Pensionados(homePage.getDriver());
        homePage.cargarURL(url);
        homePage.maximizarBrowser();
    }
    @Test
    public void CP001_mostrar_SomosAndes() {
        datosPrueba = DataDriven.prepararData("CP001_mostrar_SomosAndes");
        homePage.ir_a_SomosAndes();
        Assertions.assertEquals(datosPrueba.get(1),homePage.getTitulo());

    }

    @Test
    public void CP002_gestionar_beneficios() {
        datosPrueba = DataDriven.prepararData("CP002_gestionar_beneficios");
        homePage.ir_a_Trabajadores();
        trabajadores.obtenerBeneficios();
        Assertions.assertEquals(datosPrueba.get(1),trabajadores.getSalud());
    }

    @Test
    public void CP003_pensionados(){
        datosPrueba = DataDriven.prepararData("CP003_pensionados");
        homePage.ir_a_Pensionados();
        //pensionados.obtenerBeneficiosFar();
        Assertions.assertEquals(datosPrueba.get(1),homePage.getFarmacia());
    }
    @Test
    public void CP004_empresas(){
        datosPrueba = DataDriven.prepararData("CP004_empresas");
        homePage.ir_a_Empresas();
        Assertions.assertEquals(datosPrueba.get(1),homePage.getNovedades());
    }

    @Test
    public void CP005_mostrar_Exafiliados (){
        datosPrueba = DataDriven.prepararData("CP005_mostrar_Exafiliados");
        homePage.ir_a_ExAfiliados();
        Assertions.assertEquals(datosPrueba.get(1),homePage.getExAf());
    }

    @AfterEach
    public void posEjecucion(){
        homePage.cerrarBrowser();
    }
}
