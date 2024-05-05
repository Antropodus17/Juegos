/**
 * Paquete para el almacenaje de las clases primarias de la app
 */
package primarias;

import java.util.Random;

/**
 * Clase para el almacenaje de las minas
 */
public class Tablero {

	//ATRIBUTOS
	/**
	 * Array para la posicion de las minas
	 */
	boolean[][] tableroMinas;
	/**
	 * Array para mostrar po pantalla
	 */
	int[][] tableroMostrar;
	
	boolean[][] tableroComprobado;
	/**
	 * Tamaño del tablero
	 */
	public int size;
	/**
	 * Cantidad de minas
	 */
	public int cantidadMinas=0;
	//CONSTRUCTOR
	/**
	 * Constructor base en función de la dificultad
	 * @param tablero
	 */
	public Tablero(int i) {
		switch (i) {
		case 0: {
			size=4;
			cantidadMinas=1;
			break;
		}
		case 1: {
			size=6;
			cantidadMinas=8;
			break;
		}
		case 2: {
			size=8;
			cantidadMinas=14;
			break;
		}
		case 3: {
			size=10;
			cantidadMinas=30;
			break;
		}
		case 4:{
			size=20;
			cantidadMinas=60;
			break;
		}
		}
		this.tableroMinas=new boolean[size][size];
		this.tableroMostrar=new int[size][size];
		this.tableroComprobado=new boolean[size][size];
		iniciarMinas();
	}


	//GETTERS & SETTERS
	public boolean[][] getTableroMinas() {
		return tableroMinas;
	}
	public int[][] getTableroMostrar() {
		return tableroMostrar;
	}
	public void setTableroMostrar(int i,int j,int k) {
		this.tableroMostrar[i][j] = k;
	}
	public boolean getCeldaComprobada(int[] celda) {
		return this.tableroComprobado[celda[0]][celda[1]];
	}
	public void setCeldaComprobada(int[] celda,boolean s) {
		this.tableroComprobado[celda[0]][celda[1]]=s;
	}
	
	//METODOS
	
	/**
	 * Coloca las minas en el tablero
	 */
	private void iniciarMinas() {
		Random rd=new Random();
		for(int i=0;i<cantidadMinas;i++) {
			this.tableroMinas[rd.nextInt(size)][rd.nextInt(size)]=true;
		}
	}
}
