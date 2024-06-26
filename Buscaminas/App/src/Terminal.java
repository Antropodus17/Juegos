/**
 * Paquete principal para el desarrollo de la app
 */
package src;

import src.controladores.ControladorBase;

/**
 * Clase encargada del inicio de la app
 */
public class Terminal {

	/**
	 * Metodo de arranque
	 * @param args argumentos de entrada
	 */
	public static void main(String[] args) {
		try {
			new ControladorBase().inicio();
		} catch (InterruptedException e) {
			System.out.println("Error en las esperas");
		}
	}

}
