/**
 * 
 */
package controlador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dtos.agenciaDto;
import dtos.productoDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

/**
 * 
 */
public class inicio {

	/**
	 * @param args
	 */
	public static List<productoDto> productoLista = new ArrayList<productoDto>();
	public static List<agenciaDto> agenciaLista = new ArrayList<agenciaDto>();
	
	static LocalDate fecha = LocalDate.now();
	public static String ficheroLog = fecha + "ficheroLog.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuInterfaz mi = new MenuImplementacion();

		int opcionSeleccionada;
		boolean isCerrado = false;

		try {
			
		     FileWriter fileWriter = new FileWriter(ficheroLog, true);
	         PrintWriter printWriter = new PrintWriter(fileWriter);

			
			do {
				opcionSeleccionada = mi.MenuPrincipal();
                String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - Opción seleccionada: " + opcionSeleccionada;
				
				switch (opcionSeleccionada) {

				case 0:
					mensajeLog += " - Menú cerrado";
					System.out.println("Menu cerrado");
					isCerrado = true;
					break;
				case 1:
					mensajeLog += " - Menú de Empleado";
					mi.MenuEmpleado();
					break;
				case 2:
					mensajeLog += " - Menú de Agencia";
					mi.MenuAgencia();
					break;

				default:
					mensajeLog += " - Opción inválida";
					System.out.println("La opcion seleccionada no existe");
				}
				printWriter.println(mensajeLog);
				
			} while (!isCerrado);
			
			printWriter.close();
            fileWriter.close();
			
		} catch (Exception e) {
			
			System.out.println("La opcion seleccionada no existe" + e.getMessage());
			e.printStackTrace();
		}
	}

}
