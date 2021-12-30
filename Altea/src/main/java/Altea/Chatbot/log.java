package Altea.Chatbot;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 * Esta clase define, genera y guarda mensajes como una lista de mensajes Log.
 */
public class log {
	// Campos de la clase
	private String[] Log = { "null" };

	/**
	 * Metodo que devuelve la lista Log.
	 * 
	 * @return La lista de strings Log del dato log.
	 */
	public String[] GetLog() {
		return this.Log;
	}

	// Cierre de metodo
	/**
	 * Metodo que agrega un mensaje a la lista de mensajes del log.
	 * 
	 * @param Msg El parametro Msg representa al mensaje que se va a agregar a la
	 *            lista de mensajes de log.
	 */
	public void AppendLog(String Msg) {
		if ("null".equals(this.Log[0]) == true) {
			this.Log[0] = Msg;
		} else {
			String[] auxList = new String[this.Log.length + 1];
			for (int cont = 0; cont < this.Log.length; cont++) {
				auxList[cont] = this.Log[cont];
			}
			auxList[auxList.length - 1] = Msg;
			this.Log = auxList;
		}
	}

	// Cierre de metodo
	/**
	 * Metodo que verifica si un mensaje se encuentra dentro de la lista Log.
	 * 
	 * @param Msg El parametro Msg representa al mensaje que se buscara en la lista
	 *            de mensajes de log.
	 * @return El numero 1 si el mensaje se encuentra o el numero -1 en caso
	 *         contrario.
	 */
	public int Encontrar_Dato(String Msg) {
		if ("null".equals(this.Log[0]) == true) {
			return -1;
		} else {
			for (int cont = 0; cont < this.Log.length; cont++) {
				if (Msg.equals(this.Log[cont]) == true) {
					return 1;
				}
			}
			return -1;
		}
	}

	// Cierre del metodo
	/**
	 * Metodo que guarda el contendido de un archivo de texto en una lista Log.
	 * 
	 * @param L      EL parametro L representa al dato log que se le escribiran los
	 *               datos del archivo a su lista Log.
	 * @param nombre El parametro nombre representa el nombre del archivo que se
	 *               transferiran sus datos al dato log.
	 * @return El dato log con su lista Log actualizada con los datos del archivo.
	 */
	public static log Leer_archivo(log L, String nombre) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(nombre + ".txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				L.AppendLog(linea);
			}
			fr.close();
			return L;
		} catch (Exception e) {
			L.AppendLog("1");
			return L;
		}
	}

	// Cierre de metodo
	/**
	 * Metodo que guarda el contendido de una lista Log en un archivo de texto.
	 * 
	 * @param nombre El parametro nombre representa el nombre del archivo en el que
	 *               se escribiran los datos de la lista Log.
	 */
	public void Guardar_archivo(String nombre) {
		try {
			File archivo = new File(nombre + ".txt");
			FileWriter arch_write = new FileWriter(archivo);
			BufferedWriter arch_buff = new BufferedWriter(arch_write);
			for (int cont = 0; cont < this.Log.length; cont++) {
				arch_buff.write(this.Log[cont]);
				arch_buff.newLine();
			}
			arch_buff.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	// Cierre del metodo
}
// Cierre del clase