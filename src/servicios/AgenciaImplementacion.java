package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controlador.inicio;
import dtos.agenciaDto;

/**
 * @author csi23-nrojlla 01032024
 */
public class AgenciaImplementacion implements AgenciaInterfaz {

	Scanner sc = new Scanner(System.in);

	@Override
	public void MostrarVentasDelDia() throws IOException {

		if (inicio.agenciaLista.size() > 0) {
			
	        System.out.println("Ingrese una fecha en formato dd-MM-yyyy:");
	        String fechaIngresada = sc.next();
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate fechaBusqueda = LocalDate.parse(fechaIngresada, formato);	        

	        for (agenciaDto producto : inicio.agenciaLista) {
	        	
	            LocalDate fechaEntrega = producto.getFechaEntrega().toLocalDate();
	            
	            if (fechaEntrega.equals(fechaBusqueda)) {
	                System.out.println("--------------------------------------------" );
	                System.out.println("Venta: " + producto.getNombreProducto());
	                System.out.println("Euros: " + producto.getCosteProducto());
	                System.out.println("Instante de compra: " + producto.getFechaEntrega().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
	            }
	        }
	    } else {
	        System.out.println("No hay ventas registradas.");
	    }

	}

	@Override
	public void NuevoPedido() throws IOException {

		long id = Utils.Utils.nuevoIdAgencia();

		System.out.println("Inserte el nombre del producto");
		String nombre = sc.nextLine();
		System.out.println("Inserte la cantidad");
		double cantidad = sc.nextDouble();
		sc.nextLine();
		LocalDateTime fecha = LocalDateTime.now();

		agenciaDto nuevoPedido = new agenciaDto(id, nombre, cantidad, fecha);
		inicio.agenciaLista.add(nuevoPedido);
		

	}

}
