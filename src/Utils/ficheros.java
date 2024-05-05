/**
 * 
 */
package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import controlador.inicio;
import dtos.agenciaDto;
import dtos.productoDto;

/**
 * 
 */
public class ficheros {

	public static void CrearFichero() {
		try {
			File ventasFichero = new File(inicio.ventasFichero);
			File productoFichero = new File(inicio.empleadoVentasFichero);
			if (!ventasFichero.exists()) {
				System.out.println("Creando archivos");
				ventasFichero.createNewFile();
			}
			if (!productoFichero.exists()) {
				System.out.println("Creando archivos");
				productoFichero.createNewFile();
			}

		} catch (Exception ex) {
			System.out.println("Error inesperado: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void agregarVentasFichero() {
		try {
			// Leer el contenido del archivo para obtener las entradas existentes
			Set<String> entradasExistentes = new HashSet<>();
			
			try (BufferedReader reader = new BufferedReader(new FileReader(inicio.ventasFichero))) {
				String linea;
				while ((linea = reader.readLine()) != null) {
					entradasExistentes.add(linea.trim()); // Agregar la línea sin espacios en blanco al conjunto
				}
			}
			
			
			// Agregar nuevas entradas al archivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.ventasFichero, true))) {
				for (agenciaDto agencia : inicio.agenciaLista) {
					String nuevaEntrada = agencia.getId() + ";" + agencia.getNombreProducto() + ";"
							+ agencia.getCosteProducto() + ";"
							+ agencia.getFechaEntrega().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
					if (!entradasExistentes.contains(nuevaEntrada)) {
						bw.write(nuevaEntrada + "\n");
						System.out.println("Datos agregados al archivo de ventas.");
					}
				}
			}
		} catch (IOException ex) {
			System.out.println("Error inesperado: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public static void agregarProductoFichero() {
		try {
	        // Leer el contenido del archivo para obtener las entradas existentes
	        Set<String> entradasExistentesProducto = new HashSet<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(inicio.empleadoVentasFichero))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                entradasExistentesProducto.add(linea.trim()); // Agregar la línea sin espacios en blanco al conjunto
	            }
	        }

	        // Agregar nuevas entradas al archivo
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.empleadoVentasFichero, true))) {
	            for (productoDto producto : inicio.productoLista) {
	                String nuevaEntrada = producto.getId() + ";" + producto.getNombreProducto() + ";"
	                        + producto.getCosteProducto() + ";"
	                        + producto.getFechaCompra().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	                // Verificar si la nueva entrada ya existe en el archivo
	                if (!entradasExistentesProducto.contains(nuevaEntrada)) {
	                    bw.write(nuevaEntrada + "\n");
	                    System.out.println("Datos agregados al archivo.");
	                }
	            }
	        }
	    } catch (IOException ex) {
	        System.out.println("Error inesperado: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	}

//agregar y imprimir
	public static void leerFicheros() {

		File ventasFile = new File(inicio.ventasFichero);
		File productosFile = new File(inicio.empleadoVentasFichero);

		if (ventasFile.exists() && productosFile.exists()) {

			try (BufferedReader ventasReader = new BufferedReader(new FileReader(inicio.ventasFichero));
					BufferedReader productosReader = new BufferedReader(new FileReader(inicio.empleadoVentasFichero))) {

				String ventasLine;
				String productosLine;

				System.out.println("Contenido de pedidos");

				while ((ventasLine = ventasReader.readLine()) != null) {
					String[] ventasParts = ventasLine.split(";");
					inicio.agenciaLista.add(new agenciaDto(Long.parseLong(ventasParts[0]), ventasParts[1],
							Double.parseDouble(ventasParts[2]),
							LocalDateTime.parse(ventasParts[3], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))));
					System.out.println(ventasLine);
				}
				System.out.println("Contenido de ventas");

				while ((productosLine = productosReader.readLine()) != null) {
					String[] productosParts = productosLine.split(";");
					inicio.productoLista.add(new productoDto(Long.parseLong(productosParts[0]), productosParts[1],
							Double.parseDouble(productosParts[2]), LocalDateTime.parse(productosParts[3],
									DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))));
					System.out.println(productosLine);

				}

			} catch (Exception ex) {
				System.out.println("Error inesperado: " + ex.getMessage());
				ex.printStackTrace();
			}
		} else {
	        System.out.println("Uno o ambos archivos no existen.");
	    }
	}
}