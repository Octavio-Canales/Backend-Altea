package Altea.Chatbot;

import java.util.Random;
import java.util.Date;

/**
 * Esta clase genera la fecha y horario actual, lo cual tambien se guardan los
 * datos por separado en una lista de strings.
 */
public class fecha {
	// Campos de la clase
	private Date horario = new Date();
	private String[] dato = new String[1];

	/**
	 * Metodo que devuelve la fecha y horario actual.
	 * 
	 * @return El string equivalente a la fecha y horario actual.
	 */
	public String GetFecha() {
		String datos = "" + horario;
		return datos;
	}

	// Cierre de metodo
	/**
	 * Metodo que genera una lista dato con los datos de fecha y horario separados.
	 * 
	 * @return El dato fecha generado, con el dato horario actual y la lista dato
	 *         creada.
	 */
	public static fecha Separar_Datos() {
		fecha calendario = new fecha();
		String datos = calendario.GetFecha();
		String[] separado = datos.split(" ");
		String horas = separado[3];
		String[] horas_sep = horas.split(":");
		String[] nuevo_separado = new String[8];
		nuevo_separado[0] = separado[0];
		nuevo_separado[1] = separado[1];
		nuevo_separado[2] = separado[2];
		nuevo_separado[3] = horas_sep[0];
		nuevo_separado[4] = horas_sep[1];
		nuevo_separado[5] = horas_sep[2];
		nuevo_separado[6] = separado[4];
		nuevo_separado[7] = separado[5];
		calendario.dato = nuevo_separado;
		return calendario;
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de segundos actuales de un dato fecha creado.
	 * 
	 * @return El string equivalente a los segundos de un dato fecha creado con su
	 *         lista dato generada.
	 */
	public static String Get_Second() {
		fecha calendario = Separar_Datos();
		return calendario.dato[5];
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de minutos actuales de un dato fecha creado.
	 * 
	 * @return El string equivalente a los minutos de un dato fecha creado con su
	 *         lista dato generada.
	 */
	public static String Get_Minute() {
		fecha calendario = Separar_Datos();
		return calendario.dato[4];
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de hora actual de un dato fecha creado.
	 * 
	 * @return El string equivalente a la hora de un dato fecha creado con su lista
	 *         dato generada.
	 */
	public static String Get_Hour() {
		fecha calendario = Separar_Datos();
		return calendario.dato[3];
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de dia actual de un dato fecha creado.
	 * 
	 * @return El string equivalente al dia de un dato fecha creado con su lista
	 *         dato generada.
	 */
	public static String Get_Day() {
		fecha calendario = Separar_Datos();
		return calendario.dato[2];
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de mes actual de un dato fecha creado.
	 * 
	 * @return El string equivalente al mes de un dato fecha creado con su lista
	 *         dato generada.
	 */
	public static String Get_Month() {
		fecha calendario = Separar_Datos();
		return calendario.dato[1];
	}

	// Cierre de metodo
	/**
	 * Metodo que devuelve el dato de año actual de un dato fecha creado.
	 * 
	 * @return El string equivalente al año de un dato fecha creado con su lista
	 *         dato generada.
	 */
	public static String Get_Year() {
		fecha calendario = Separar_Datos();
		return calendario.dato[7];
	}

	// Cierre de metodo
	/**
	 * Metodo que crea un string con los datos ordenados de fecha y hora.
	 * 
	 * @return El string equivalente a la fecha y hora ordenada al generar un dato
	 *         fecha.
	 */
	public static String GetDate() {
		fecha datos = Separar_Datos();
		String calendario = datos.Get_Year() + "/" + datos.Get_Month() + "/" + datos.Get_Day() + "-" + datos.Get_Hour()
				+ ":" + datos.Get_Minute() + ":" + datos.Get_Second();
		return calendario;
	}
	// Cierre de metodo
}
// Cierre de clase