package servicios;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import controlador.inicio;
import dtos.productoDto;

/**
 * @author csi23-nrojlla 01032024
 */
public class EmpleadoImplementacion implements EmpleadoInterfaz {

	Scanner sc = new Scanner(System.in);

	@Override
	public void CalculoTotalDiario() throws IOException {

		if (inicio.productoLista.size() > 0) {

			System.out.println("Ingrese una fecha formato(dd-MM-yyyy)");
			String Ingresefecha = sc.next();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate fecha = LocalDate.parse(Ingresefecha, formato);

			try {
				
				double totalDia = 0.0;

				LocalDateTime primeraFechaCompra = inicio.productoLista.get(0).getFechaCompra();
				LocalDateTime ultimaFechaCompra = inicio.productoLista.get(inicio.productoLista.size() - 1).getFechaCompra();

				
				for (productoDto producto : inicio.productoLista) {
					
					LocalDate fechaCompraProducto = producto.getFechaCompra().toLocalDate(); 
																								
					if (fechaCompraProducto.equals(fecha)) {
						
						totalDia += producto.getCosteProducto();
						
					}
				}
				
				Duration duracion = Duration.between(primeraFechaCompra, ultimaFechaCompra);
				
				long dias = duracion.toDays();
				long horas = duracion.toHours() % 24;
				long minutos = duracion.toMinutes() % 60;
				long segundos = duracion.getSeconds() % 60;

				System.out.println("Diferencia entre primera y última fecha de compra: " + dias + " días, " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos");
				System.out.println("Total del día: " + totalDia + "$");
				System.out.println("Fecha: " + fecha);

			} catch (DateTimeParseException e) {
				System.out.println(
						"Error: La fecha ingresada no es válida. Por favor, ingrese una fecha en formato dd-MM-yyyy.");
			}

		}
	}

	@Override
	public void AgregarVenta() throws IOException {

		long id = Utils.Utils.nuevoID();
		System.out.println("Inserte el nombre del producto");
		String nombre = sc.nextLine();
		System.out.println("Inserte el coste del producto");
		double coste = sc.nextDouble();
		sc.nextLine();
		LocalDateTime fecha = LocalDateTime.now();

		productoDto nuevaVenta = new productoDto(id, nombre, coste, fecha);		
		inicio.productoLista.add(nuevaVenta);
	}
}
