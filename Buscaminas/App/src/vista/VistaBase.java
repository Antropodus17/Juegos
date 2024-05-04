/**
 * Paquete para el almacenaje de las vistas
 */
package src.vista;

import primarias.Tablero;

/**
 * Vista principal de la app
 */
public class VistaBase {

	// ATRIBUTOS

	public void bienvenida() {
		System.out.println("Bienvenido al buscaminas\n" + "Seleccione la dificultad:\n" + "1) Periodista\n"
				+ "2) Fácil\n" + "3) Medio\n" + "4) Dificil\n"+"5) Infernal");
	}

	/**
	 * Metodo para mostrar estado del tablero
	 * 
	 * @param t el tablero de juego
	 */
	public void mostrarTablero(Tablero t) {
		char letras = 'A';
		System.out.print("   ");
		for (int i = 0; i < t.size; i++) {
			System.out.print(letras++ + " ");
		}
		System.out.println();
		for (int i = 0; i < t.size; i++) {
			System.out.print((i<10?"0"+i:i)+ " ");
			for (int j = 0; j < t.size; j++) {
				int celda = t.getTableroMostrar()[i][j];
				if (celda == 0) {
					System.out.print("■ ");
				} else if (celda == -1) {
					System.out.print(0 + " ");
				} else if(celda == 10){
					System.out.print("• ");
				}	else {
					System.out.print(celda + " ");
				}
			}
			System.out.println();
		}
	}
}
