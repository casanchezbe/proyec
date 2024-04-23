package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import models.Constantes;
import models.DataExitoLoombokData;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.SeleccionarCatYSub;
import tasks.SeleccionarProductos;

public class CompraExitoStepDefinitions {

    @Dado("el usuario ingresa a la pagina exito")
    public void elUsuarioIngresaALaPaginaExito(DataTable table) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(Constantes.ACTOR).wasAbleTo(Open.url(DataExitoLoombokData.setData(table).get(0).getUrl()));

    }

    @Cuando("selecciona la categoria y subcategoria")
    public void seleccionaLaCategoriaYSubcategoria(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCatYSub.seleccionarDatos(DataExitoLoombokData.setData(table).get(0)));
    }

    @Y("selecciona productos aleatoriamente")
    public void seleccionaProductosAleatoriamente() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarProductos.fromWebDriver());
    }
}
