package menu.Documentacion.BandejaDeSalida;

import java.util.ArrayList;
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
		//Espera.espera(35000);
		PageBandejaDeSalida.BOTON_REFRESCAR.click();
		Espera.obligatoriamente(3000);

	}

	@Step("El usuario se descarga el formuluario de adiestramiento con el lote {0} y dni {1}")
	public void delFormularioDeAdiestramiento(String lote, String dni,String puesto) {
		this.desplegarPestanias(lote, dni,puesto);
		Espera.obligatoriamente(2000);
		this.descargaFormularioAdiestramiento();
	}

	@Step("El usuario se descarga el formuluario de adiestramiento con el lote {0}, dni {1} y puesto {2} y el archivo CUR")
	public void deLosFormulariosAdiestramientoYCUR(String lote, String dni, String puesto) {
		this.desplegarPestanias(lote, dni, puesto);
		Espera.obligatoriamente(2000);
		this.descargaFormularioAdiestramiento();
		Espera.obligatoriamente(2000);
		this.descargaFormularioRespuesta();
	}
	@Step("El usuario despliega las pestania de la tabla")
	private void desplegarPestanias(String lote, String dni, String puesto) {
		this.desplegarPestaniaDeLaTabla(lote);
		Espera.obligatoriamente(2000);
		this.desplegarPestaniaDeLaTabla(dni);
		Espera.obligatoriamente(4000);
		this.desplegarPestaniaDeLaTabla(puesto);
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario se descarga el formulario de adiestramiento",
					"descargarFormulario");
		}
		Espera.obligatoriamente(2000);
	}

	private void desplegarPestaniaDeLaTabla(String titulo) {
		// filas
		List<WebElement> rows = PageBandejaDeSalida.TABLA.findElements(By.tagName("tr"));
		List<WebElement> columnas = null;
		List<WebElement> enlaces = null;
		for (int i = 0; i < rows.size(); i++) {
			columnas = rows.get(i).findElements(By.tagName("td"));
			enlaces = rows.get(i).findElements(By.tagName("a"));
		}
		WebElement enlaceDeseado = null;
		for (int i = 0; i < columnas.size(); i++) {
			for (int enlace = 0; enlace < enlaces.size(); enlace++) {
				if (columnas.get(i).getText().contains(titulo)) {
					enlaceDeseado = enlaces.get(enlace);
				}
			}
		}
		enlaceDeseado.click();
	}
/*
	private void descargarFormulario(String fichero) {
		// TODO Auto-generated method stub
		List<WebElement> rows = PageBandejaDeSalida.TABLA.findElements(By.tagName("tr"));
		WebElement columnaDeseada = null;

		for (int rnum = 0; rnum < rows.size(); rnum++) {
			System.out.println("fila:" + rows.get(rnum).getText());
			if (rnum == 3) {
				System.out.println("DENTRO " + rows.get(rnum).getText());
				columnaDeseada = rows.get(rnum).findElement(By.tagName("button"));
			}
		}
		columnaDeseada.click();
	}
*/
	/////////////////////////////////
	private void descargaFormularioAdiestramiento() {
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
			if (rnum == posicionLotePrincipal + 6) {// le sumamos 6 ya que el archivo que buscamos está en el tr 7
				columnaDeseada = rows.get(rnum).findElement(By.tagName("button"));
			}
		}
		
		columnaDeseada.click();
	}
	private void descargaFormularioRespuesta() {
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
			if (rnum == posicionLotePrincipal + 5) {// le sumamos 5 ya que el archivo que buscamos está en el tr 6
				System.out.println("DENTRO " + rows.get(rnum).getText());
				columnaDeseada = rows.get(rnum).findElement(By.tagName("button"));
			}
		}
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario se descarga el archivo CUR","descargarFormulario");
		}
		Espera.obligatoriamente(1000);
		columnaDeseada.click();
	}
}
