/**
 * Paquete para el almacenaje de los controladores
 */
package src.controladores;

import primarias.Tablero;
import src.modelos.ModeloBase;
import src.vista.VistaBase;

/**
 * Controlador base de la app
 */
public class ControladorBase {

	// ATRIBUTOS
	/**
	 * Vista base de la app
	 */
	VistaBase vb;
	/**
	 * Modelo base de la app
	 */
	ModeloBase mb;
	/**
	 * Tablero de juego
	 */
	Tablero t;

	// CONSTRUCTORES
	/**
	 * Constructor básico
	 */
	public ControladorBase() {
		this.mb = new ModeloBase();
		this.vb = new VistaBase();
	}

	// METODOS
	/**
	 * Metodo de inicio de la app
	 */
	public void inicio() {
		boolean seguirApp = true,seguirJuego=true;
		while (seguirApp) {
			vb.bienvenida();
			t=new Tablero(mb.dificultad());
			while(seguirJuego) {
				vb.mostrarTablero(t);
				if(mb.comprobarCelda(t, mb.elegirCelda(t))) {
					vb.mostrarTablero(t);
					System.out.println("Game over");
					seguirJuego=false;
				}
			}
		}
	}
}
