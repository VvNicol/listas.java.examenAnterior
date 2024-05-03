package servicios;

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
	void MostrarVentasDelDia(List<agenciaDto> agenciaLista);
	/**
	 * un nuevo pedido
	 * @param agenciaLista
	 */
	void NuevoPedido(List<agenciaDto> agenciaLista);

}
