/**
 * 
 */
package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controlador.inicio;

/**
 * @author csi23-nrojlla 01032024 menu de impletacion de metodos
 */
public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner(System.in);
	
	private void escribirEnFicheroLog(String mensaje) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(inicio.ficheroLog, true))) {
            printWriter.println(mensaje);
        }
    }
	
	@Override
	public int MenuPrincipal() throws IOException {

		System.out.println("-----------------");
		System.out.println("Menu Principal");
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Menu empleado");
		System.out.println("2. Menu agencia");
		System.out.println("-----------------");

		int opcionMenuP = sc.nextInt();

		return opcionMenuP;
	}

	@Override
	public void MenuEmpleado() throws IOException {

		EmpleadoInterfaz ei = new EmpleadoImplementacion();
		boolean esCerrado = false;
		int menuEmpleado;
		
		do {
			menuEmpleado = MenuEmpleadoMostrar();
            String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - Opción seleccionada en Menú Empleado: " + menuEmpleado;

			switch (menuEmpleado) {

			case 0:
				mensajeLog += " - Volver";
				esCerrado = true;
				break;
			case 1:
				mensajeLog += " - Calculo total diario";
				ei.CalculoTotalDiario();
				break;
			case 2:
				mensajeLog += " - Agregar una venta";
				ei.AgregarVenta();
				break;

			default:
				
				System.out.println("La opcion seleccionada no existe");
			}
			
			escribirEnFicheroLog(mensajeLog);
			
		} while (!esCerrado);
	}

	private int MenuEmpleadoMostrar() throws IOException {

		System.out.println("-----------------");
		System.out.println("Menu Empleado");
		System.out.println("0. Volver");
		System.out.println("1. Cálculo total de ventas diario");
		System.out.println("2. Añadir venta");
		System.out.println("-----------------");

		int opcionMenuE = sc.nextInt();

		return opcionMenuE;

	}

	@Override
	public void MenuAgencia() throws IOException {

		AgenciaInterfaz ai = new AgenciaImplementacion();
		boolean esCerrado = false;
		int menuAgencia;
		
		do {
			
			menuAgencia = MenuAgenciaMostrar();
            String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - Opción seleccionada en Menú Agencia: " + menuAgencia;

			switch (menuAgencia) {

			case 0:
				mensajeLog += " - Volver";
				esCerrado = true;
				break;
			case 1:
				
				mensajeLog += " - Mostrar ventas del dia";
				ai.MostrarVentasDelDia();
				break;
			case 2:
				
				mensajeLog += " - Nuevo pedido";
				ai.NuevoPedido();
				break;

			default:
				mensajeLog += " - Opcion invalida";
				System.out.println("La opcion seleccionada no existe");
			
				escribirEnFicheroLog(mensajeLog);

			}
		} while (!esCerrado);
		
	}

	private int MenuAgenciaMostrar() throws IOException {

		System.out.println("-----------------");
		System.out.println("Menu Agencia");
		System.out.println("0. Volver");
		System.out.println("1. Mostrar ventas del dia");
		System.out.println("2. Nuevo pedido para proveedores");

		int opcionMenuA = sc.nextInt();

		return opcionMenuA;
	}

}
