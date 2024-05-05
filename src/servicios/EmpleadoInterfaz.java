/**
 * 
 */
package servicios;

import java.io.IOException;
import java.util.List;

import dtos.productoDto;
/**
 * @author csi23-nrojlla
 * 01032024
 */
public interface EmpleadoInterfaz {

	/**
	 * logica del calculo
	 * @param productoLista
	 */
	void CalculoTotalDiario() throws IOException;

	/**
	 * se agrega una venta
	 * @param productoLista
	 */
	void AgregarVenta() throws IOException;

}
