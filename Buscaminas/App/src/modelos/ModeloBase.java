/**
 * Paquete para el almacenaje de los modelos
 */
package src.modelos;

import java.util.Scanner;
import java.util.regex.Pattern;

import primarias.Tablero;

/**
 * Modelo base de la app
 */
public class ModeloBase {

	// ATRIBUTOS
	/**
	 * Scanner para la recogida del teclado
	 */
	Scanner sc;

	// CONSTRUCTORES
	/**
	 * Constructor base
	 */
	public ModeloBase() {
		super();
		this.sc = new Scanner(System.in);
	}

	// METODOS
	/**
	 * Método para la elegir la dificultad
	 * 
	 * @return la dificultad en un número
	 */
	public int dificultad() {
		System.out.println("(1-5)");
		String devolver = sc.nextLine().trim();
		while (!Pattern.matches("(1|2|3|4|5)", devolver)) {
			System.out.print("Opcion no válida\nPrueba de nuevo: ");
			devolver = sc.nextLine().trim();
		}
		return Integer.parseInt(devolver) - 1;
	}

	/**
	 * Comprueba si la celda contiene una mina
	 * 
	 * @param celda celda a revisar
	 * @return true si hay mina
	 */
	public boolean comprobarCelda(Tablero t, int[] celda) {
		if (t.getTableroMinas()[celda[0]][celda[1]]) {
			t.setTableroMostrar(celda[0], celda[1], 10);
			return true;
		}
		revelarCasillas(t, celda);
		return false;
	}

	/**
	 * Cambia el tabero a mostrar
	 * 
	 * @param t     el tablero de juego
	 * @param celda la casilla a revelar;
	 */
	private void revelarCasillas(Tablero t, int[] celda) {
		int minas = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (((celda[0] + i >= 0) && (celda[1] + j >= 0))
						&& ((celda[0] + i < t.size) && (celda[1] + j < t.size))) {
					if (t.getTableroMinas()[celda[0] + i][celda[1] + j]) {
						minas++;
					}
				}
			}
		}
		if (minas == 0) {
			t.setTableroMostrar(celda[0], celda[1], -1);
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (((celda[0] + i >= 0) && (celda[1] + j >= 0))
							&& ((celda[0] + i < t.size) && (celda[1] + j < t.size))) {
						int[] nuevaCelda = { celda[0] - i, celda[1] - j };
						revelarCasillas(t, nuevaCelda);
					}
				}
			}
		} else {
			t.setTableroMostrar(celda[0], celda[1], minas);
		}
	}

	/**
	 * Devuelve el index de la celda selecionada
	 * 
	 * @param t El tablero de juego
	 * @return La posicion de la celda
	 */
	public int[] elegirCelda(Tablero t) {
		int fila = selecionarNumero(t.size);
		int columna = selecionarLetra(t.size);
		int[] devolver = { fila, columna };
		return devolver;
	}

	/**
	 * Obtiene el numero de la fila
	 * 
	 * @param t Tamaño del tablero
	 * @return El número
	 */
	private int selecionarNumero(int t) {
		System.out.print("Introduzca el número de la fila: ");
		String devolver = sc.nextLine();
		String regrex = "(0";
		for (int i = 1; i < t; i++) {
			regrex += "|" + i;
		}
		regrex += ")";
		while (!Pattern.matches(regrex, devolver)) {
			System.out.println("Fila no válida\nIntroduzca el número de la fila: ");
			devolver = sc.nextLine();
		}
		return Integer.parseInt(devolver);
	}

	/**
	 * Obtiene el número de la columna
	 * 
	 * @return
	 */
	private int selecionarLetra(int t) {
		System.out.print("Introduzca la letra de la fila: ");
		char patron = 'B';
		String columna = sc.nextLine();
		String regrex = "(A";
		for (int i = 1; i < t; i++) {
			regrex += "|" + patron++;
		}
		regrex += ")";
		while (!Pattern.matches(regrex, columna.trim())) {
			System.out.println("Columna no válida\nIntroduzca la letra de la columna: ");
			columna = sc.nextLine().trim();
		}
		byte devolver = (byte) columna.charAt(0);
		return devolver - 65;
	}

}
