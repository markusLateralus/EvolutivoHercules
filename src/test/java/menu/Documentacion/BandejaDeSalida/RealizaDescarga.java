package menu.Documentacion.BandejaDeSalida;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class RealizaDescarga extends UIInteractionSteps {

	PageBandejaDeSalida bandejaDeSalida;
	private Espera espera = new Espera();

	@Step("El usuario actualiza la pagina para encontrar la documentación generada")
	public void actualizarPagina() {
		Espera.espera(40000);
		PageBandejaDeSalida.BOTON_REFRESCAR.click();
		Espera.espera(3000);

	}

	@Step("El usuario se descarga el formuluario de adiestramiento con el lote{lote}, dni{dni} y puesto{puesto}")
	public void delFormularioDeAdiestramiento(String lote, String dni, String puesto) {
		this.desplegarPestanias(lote, dni, puesto);
		Espera.espera(2000);
		this.descargar();
	}

	@Step("El usuario despliega las pestania de la tabla")
	private void desplegarPestanias(String lote, String dni, String puesto) {
		// String lote="marcos";
		// String dni="25428266H";
		// String puesto="94527";
		this.desplegarPestaniaDeLaTabla(lote);
		Espera.espera(2000);
		this.desplegarPestaniaDeLaTabla(dni);
		Espera.espera(2000);
		this.desplegarPestaniaDeLaTabla(puesto);
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario se descarga el formulario de Adiestramiento",
					"descargarFormulario");
		}
		Espera.espera(2000);
	}

	@Step("El usuario se descarga el formulario de Adiestramiento")
	public void descargar() {
		String tituloDocumento = "F-820-080-75 Certificacion de adiestramiento tutelado. Actividades de Seguidad Sistemas de Seguridad.pdf";
		descargarDocumento(tituloDocumento);
		Espera.espera(1000);
	}

	private void desplegarPestaniaDeLaTabla(String titulo) {
		// filas
		List<WebElement> rows = PageBandejaDeSalida.TABLA.findElements(By.tagName("tr"));
		// System.out.println("total de rows: " + rows.size());
		List<WebElement> columnas = null;
		List<WebElement> enlacesSuperiores = null;
		for (int i = 0; i < rows.size(); i++) {
			columnas = rows.get(i).findElements(By.tagName("td"));
			enlacesSuperiores = rows.get(i).findElements(By.tagName("a"));
		}
		// System.out.println("total de columnas: " +columns.size());
		WebElement enlaceDeseado = null;
		for (int i = 0; i < columnas.size(); i++) {
			// espera.queSeaclicable(Duration.ofSeconds(5), columnas.get(i));
			for (int enlace = 0; enlace < enlacesSuperiores.size(); enlace++) {
				if (columnas.get(i).getText().equalsIgnoreCase(titulo)) {
					enlaceDeseado = enlacesSuperiores.get(enlace);

				}
			}
		}
		enlaceDeseado.click();
	}

	/////////////////////////////////
	private void descargarDocumento(String titulo) {
		List<WebElement> rows = PageBandejaDeSalida.TABLA.findElements(By.tagName("tr"));
		// System.out.println("seleccionar 4");
		System.out.println("total de rows: " + rows.size());
		// se utilizará para encontrar el elemento tr de la tabla de nuestro lote
		int posicionLotePrincipal = 0;
		int totalLotes = rows.size();
		// cada Lote tiene un total de 10 tr, si hay mas de 10 tr significa que hay dos
		// lotes o más
		if (totalLotes > 10 && totalLotes<=20) {    ///ESTOS filtros se realiza para cada ejecución de un rol en concreto. Por tanto minimo se crean 4 Lotes en la ejecución de la prueba
			posicionLotePrincipal = 1;
		} else if (totalLotes > 20 && totalLotes<=30) {
			posicionLotePrincipal = 2;
		} else if (totalLotes > 30 && totalLotes<=40) {
			posicionLotePrincipal = 3;
		} else if (totalLotes > 40 && totalLotes<=50) {
			posicionLotePrincipal = 4;
		}

		System.out.println("posicion " + posicionLotePrincipal);
		WebElement columnaDeseada = null;

		for (int rnum = 0; rnum < rows.size(); rnum++) {
			//System.out.println("fila:" + rows.get(rnum).getText());
			if (rnum == posicionLotePrincipal + 6) {// le sumamos 6 ya que el archivo que buscamos está en el tr 7
				System.out.println("DENTRO " + rows.get(rnum).getText());
				columnaDeseada = rows.get(rnum).findElement(By.tagName("button"));
			}
		}
		columnaDeseada.click();
	}
}
