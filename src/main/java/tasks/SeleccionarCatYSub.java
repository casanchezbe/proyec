package tasks;

import interactions.SeleccionarElementos;
import models.DataExitoLoombokData;
import userinterfaces.PaginaExitoObjetos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCatYSub implements Task {

    private DataExitoLoombokData dataExitoLoombokData;

    public SeleccionarCatYSub(DataExitoLoombokData dataExitoLoombokData) {

        this.dataExitoLoombokData = dataExitoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaExitoObjetos.MENU_BTN,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaExitoObjetos.MENU_BTN),
                SeleccionarElementos.elemento(PaginaExitoObjetos.CONTENEDOR_SELECCIONAR_CATEGORIA, dataExitoLoombokData.getCategoria()),
                Click.on(PaginaExitoObjetos.getSubCategory(dataExitoLoombokData.getSubcategoria()))
        );
    }
    public static SeleccionarCatYSub seleccionarDatos(DataExitoLoombokData dataExitoLoombokData) {
        return Instrumented.instanceOf(SeleccionarCatYSub.class).withProperties(dataExitoLoombokData);
    }
}
