package Altea.Chatbot;

import java.util.ArrayList;

/**
 * Esta clase define un objeto que puede contener una lista de mensajes, un
 * nombre y una edad.
 */
public class usuario {
	// Campos de la clase
	private String[] Usuario = { "null" };
	private String Nombre = "Usuario";
	private int Edad = 0;

	/**
	 * Metodo que devuelve la lista de mensajes del usuario.
	 * 
	 * @return La lista de strings correspondiente a la lista de mensajes del
	 *         usuario.
	 */
	public String[] GetUsuario() {
		return this.Usuario;
	}

	// Cierre del metodo
	/**
	 * Metodo que devuelve el nombre del usuario.
	 * 
	 * @return El string correspondiente al nombre del usuario.
	 */
	public String GetNombre() {
		return this.Nombre;
	}

	// Cierre del metodo
	/**
	 * Metodo que devuelve la edad del usuario.
	 * 
	 * @return El entero correspondiente a la edad del usuario.
	 */
	public int GetEdad() {
		return this.Edad;
	}

	// Cierre del metodo
	/**
	 * Metodo que cambia el nombre del usuario.
	 * 
	 * @param name El parametro name representa al nombre que se le va a cambiar al
	 *             usuario.
	 */
	public void ChangeNombre(String name) {
		this.Nombre = name;
	}

	// Cierre de metodo
	/**
	 * Metodo que cambia la edad del usuario.
	 * 
	 * @param year El parametro year representa a la edad que se le va a cambiar al
	 *             usuario.
	 */
	public void ChangeEdad(int year) {
		this.Edad = year;
	}

	// Cierre de metodo
	/**
	 * Metodo que agrega un mensaje a la lista de mensajes del usuario.
	 * 
	 * @param Msg El parametro Msg representa al mensaje que se va a agregar a la
	 *            lista de mensajes de usuario.
	 */
	public void AppendUsuario(String Msg) {
		if ("null".equals(this.Usuario[0]) == true) {
			this.Usuario[0] = Msg;
		} else {
			String[] auxList = new String[this.Usuario.length + 1];
			for (int cont = 0; cont < this.Usuario.length; cont++) {
				auxList[cont] = this.Usuario[cont];
			}
			auxList[auxList.length - 1] = Msg;
			this.Usuario = auxList;
		}
	}
	// Cierre de metodo
}
// Cierre de la calse