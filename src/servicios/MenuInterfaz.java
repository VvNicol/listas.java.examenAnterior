package servicios;

import java.io.IOException;

/**
 * @author csi23-nrojlla 01032024 menus que hay en la aplicacion
 */
public interface MenuInterfaz {

	/**
	 * 
	 * @return int para la seleccion
	 * @throws IOException 
	 */
	int MenuPrincipal() throws IOException;

	/**
	 * menu del empleado
	 * @throws IOException 
	 */
	void MenuEmpleado () throws IOException;

	/**
	 * menu de la agencia
	 * @throws IOException 
	 */
	void MenuAgencia() throws IOException;

}
