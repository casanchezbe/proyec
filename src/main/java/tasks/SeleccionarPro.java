package tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import userinterfaces.PaginaExitoObjetos;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarPro implements Task {
    private  Random rnd=new Random();

    public static SeleccionarPro aleatorio() {
        return instrumented(SeleccionarPro.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(PaginaExitoObjetos.CONTENEDOR_PRODUCTOS.resolveFor(actor).isVisible()){
            List<WebElementFacade> products=PaginaExitoObjetos.CONTENEDOR_PRODUCTOS.resolveAllFor(actor);
            List <WebElementFacade> productsValues=ExitoPage.PRODUCT_PRICE.resolveAllFor(actor);
            List <WebElementFacade> productsNames=ExitoPage.PRODUCT_NAME.resolveAllFor(actor);
            int i =rnd.nextInt(products.size());
            ProductsData.setProductsValues(productsValues.get(i).getText());
            ProductsData.setProductsNames(productsNames.get(i).getText());
            actor.attemptsTo(Scroll.to(products.get(i)));
            executor.executeScript("arguments[0].click();", products.get(i));
            if(!ExitoPage.PLUS_BUTTON.resolveFor(actor).isVisible()){
                actor.attemptsTo(
                        Scroll.to(ExitoPage.ADD_BUTTON),
                        Click.on(ExitoPage.ADD_BUTTON)
                );
            }else{
                actor.attemptsTo(
                        Scroll.to(ExitoPage.PLUS_BUTTON),
                        MultiplesClick.plusButton()
                );
            }

            executor.executeScript("window.window.scrollBy(0,-250)", "");
            actor.attemptsTo(
                    Scroll.to(ExitoPage.MODAL_CLOSE),
                    Click.on(ExitoPage.MODAL_CLOSE)
            );
            if(ExitoPage.MODAL_TITLE.resolveFor(actor).isVisible() && ExitoPage.MODAL_CLOSE.resolveFor(actor).isVisible()){
                actor.attemptsTo(
                        Click.on(ExitoPage.MODAL_CLOSE)
                );
            }


        }
    }
}
