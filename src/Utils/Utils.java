/**
 * 
 */
package Utils;

import java.io.IOException;

import controlador.inicio;

/**
 * 
 */
public class Utils {

	public static long nuevoID() throws IOException {

		long nuevoId;
		int tamanioLista = inicio.productoLista.size();

		if (inicio.productoLista.size() <= 0) {
			nuevoId = 1;
		} else {
			nuevoId = inicio.productoLista.get(tamanioLista - 1).getId() + 1;
		}

		return nuevoId;
	}

	public static long nuevoIdAgencia() throws IOException {

		long nuevoId;
		int tamanioLista = inicio.agenciaLista.size();

		if (inicio.agenciaLista.size() <= 0) {
			nuevoId = 1;
		} else {
			nuevoId = inicio.agenciaLista.get(tamanioLista - 1).getId() + 1;
		}

		return nuevoId;
	}

}
