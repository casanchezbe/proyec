package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaExitoObjetos {
    public static final Target MENU_BTN=Target.the("opcion de menu").located(By.xpath("//button[@aria-label='Collapse menu']"));
    public static final Target CONTENEDOR_SELECCIONAR_CATEGORIA = Target.the("contenedor para seleccionar categoria").located(By.xpath("//*[@id='__next']/header/aside/ul/section[2]/div"));

    public static final Target CONTENEDOR_PRODUCTOS = Target.the("contenedor para seleccionar categoria").located(By.xpath("//ul[@data-fs-product-grid-type='hogar']"));

    public static Target getSubCategory(String subcategory) {
        return Target.the("subcategoria boton").located(By.xpath("//a[contains(text(),'"+subcategory+"')]"));
    }
}
