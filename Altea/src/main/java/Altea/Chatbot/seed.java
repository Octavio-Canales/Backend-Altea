package Altea.Chatbot;

import java.util.Random;

/**
 * Esta clase define y genera un numero semilla pseudoaleatorio seed entre 0 y
 * 2.
 */
public class seed {
	// Campos de la clase
	private int Seed = 0;

	/**
	 * Metodo que devuelve el numero seed.
	 * 
	 * @return El digito correspondiente al numero Seed.
	 */
	public int GetSeed() {
		return this.Seed;
	}

	// Cierre de metodo
	/**
	 * Metodo que crea un nuevo dato seed con un nuevo numero aleatorio seed dado
	 * por cadena.
	 * 
	 * @param cadena El parametro cadena representa una palabra qe se convertira en
	 *               digito para generar el numero aleatorio seed.
	 */
	public void GenerarSeed(String cadena) {
		int numero = Integer.parseInt(cadena);
		Random aleatorio = new Random();
		numero = 1 + (numero % 3);
		this.Seed = aleatorio.nextInt(numero);
	}
	// Cierre de metodo
}
// Cierre de clase