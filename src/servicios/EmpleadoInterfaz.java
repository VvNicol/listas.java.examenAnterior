/**
 * 
 */
package servicios;

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
	void CalculoTotalDiario();

	/**
	 * se agrega una venta
	 * @param productoLista
	 */
	void AgregarVenta(List<productoDto> productoLista);

}
