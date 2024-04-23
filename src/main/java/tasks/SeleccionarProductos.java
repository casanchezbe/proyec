package tasks;


import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.Actor;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SeleccionarProductos implements Task {

    Target lista;

    public static SeleccionarProductos fromWebDriver() {
        return instrumented(SeleccionarProductos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        lista = Target.the("contenedor para seleccionar categoria").located(By.xpath("//ul[@data-fs-product-grid-type='hogar']"));
        WebElement elemento = lista.resolveFor(actor);
        List<WebElement> opciones = elemento.findElements(By.tagName("li"));
        Random rand = new Random();
        int randomIndex = rand.nextInt(opciones.size());
        // Seleccionar el elemento li aleatorio
        WebElement randomListItem = opciones.get(randomIndex);
        // Hacer clic en el elemento seleccionado
        randomListItem.click();
    }
}


