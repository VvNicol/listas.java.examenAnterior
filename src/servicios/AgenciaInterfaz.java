package servicios;

import java.io.IOException;
import java.util.List;

import dtos.agenciaDto;
/**
 * @author csi23-nrojlla
 * 01032024
 */
public interface AgenciaInterfaz {

	/**
	 * muestras las ventas del dia
	 * @param agenciaLista
	 */
	void MostrarVentasDelDia() throws IOException;
	/**
	 * un nuevo pedido
	 * @param agenciaLista
	 */
	void NuevoPedido() throws IOException;

}
