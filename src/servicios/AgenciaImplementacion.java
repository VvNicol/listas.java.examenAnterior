package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dtos.agenciaDto;
import dtos.productoDto;

/**
 * @author csi23-nrojlla 01032024
 */
public class AgenciaImplementacion implements AgenciaInterfaz {

	Scanner sc = new Scanner(System.in);

	@Override
	public void MostrarVentasDelDia(List<agenciaDto> agenciaLista) {
		
		if (agenciaLista.size() > 0) {

			System.out.println("Ingrese una fecha formato(dd-MM-yyyy)");
			String Ingresefecha = sc.nextLine();
			for (agenciaDto producto : agenciaLista) {

				if (producto.getFechaEntrega().equals(Ingresefecha)) {

					String fecha = Ingresefecha;

					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

					fecha = fecha.format(Ingresefecha, formato);

					System.out.println("venta: " + producto.getNombreProducto());
					System.out.println("Euros: " + producto.getCosteProducto());
					System.out.println("Instante de compra: " + fecha);

				}

			}
		}

	}

	@Override
	public void NuevoPedido(List<agenciaDto> agenciaLista) {

		long id = nuevoID(agenciaLista);

		System.out.println("Inserte el nombre del producto");
		String nombre = sc.nextLine();
		System.out.println("Inserte el nombre del producto");
		int cantidad = sc.nextInt();
		sc.next();
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		String fechaEntrega = fecha.format(formato);

		agenciaDto nuevoPedido = new agenciaDto(id, nombre, cantidad, fechaEntrega);
		agenciaLista.add(nuevoPedido);

	}

	private long nuevoID(List<agenciaDto> agenciaLista) {
		long nuevoId;
		int tamanioLista = agenciaLista.size();
		if (agenciaLista.size() > 0) {
			nuevoId = 1;
		} else {

			nuevoId = agenciaLista.get(tamanioLista - 1).getId() + 1;
		}

		return nuevoId;
	}

}
