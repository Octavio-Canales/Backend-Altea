package Altea.Chatbot;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

/**
 * Esta clase principal genera una entrega y envio de mensajes entre un chatbot
 * y un usuario.
 */
public class chatbot {
	/**
	 * Metodo que verifica si una palabra es en verdad un numero.
	 * 
	 * @param str El parametro str corresponde a la palabra que se verificara.
	 * @return El numero 1 si es un numero, sino el numero -1 en caso contrario.
	 */
	public static int IsNumber(String str) {
		String numeros = "0123456789";
		for (int cont = 0; cont < str.length(); cont++) {
			if ((str.substring(cont, cont + 1).equals(numeros.substring(0, 1)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(1, 2)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(2, 3)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(3, 4)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(4, 5)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(5, 6)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(6, 7)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(7, 8)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(8, 9)) == false)
					&& (str.substring(cont, cont + 1).equals(numeros.substring(9, 10)) == false)) {
				return -1;
			}
		}
		return 1;
	}

	// Cierre de metodo
	/**
	 * Metodo que convierte las letras mayusculas de una palabra en minusculas.
	 * 
	 * @param str El parametro str corresponde a la palabra en la que sus letras
	 *            mayusculas seran minusculas.
	 * @return El nuevo str con los cambios realizados.
	 */
	public static String ChangeMin(String str) {
		String[] abc_May = { "A", "B", "C", "D", "E", "F", "G", "I", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] abc_Min = { "a", "b", "c", "d", "e", "f", "g", "i", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String palabra = "";
		String caracter = "";
		for (int cont = 0; cont < str.length(); cont++) {
			caracter = str.substring(cont, cont + 1);
			for (int cont2 = 0; cont2 < abc_Min.length; cont2++) {
				if (str.substring(cont, cont + 1).equals(abc_May[cont2]) == true) {
					caracter = abc_Min[cont2];
				}
			}
			palabra = palabra + caracter;
		}
		return palabra;
	}

	// Cierre de metodo
	/**
	 * Metodo que verifica si una palabra se encuentre dentro de algun mensaje.
	 * 
	 * @param str      El parametro str corresponde a la palabra que se desea
	 *                 buscar.
	 * @param list_str El parametro list_str corresponde al mensaje convertido en
	 *                 una lista separada por palabras.
	 * @return El numero -1 si la palabra se encuentra en el mensaje, sino el numero
	 *         -1 en caso contrario.
	 */
	public static int Buscar(String[] list_str, String str) {
		for (int cont = 0; cont < list_str.length; cont++) {
			if (ChangeMin(str).equals(ChangeMin(list_str[cont])) == true) {
				return 1;
			}
		}
		return -1;
	}

	// Cierre de metodo
	/**
	 * Metodo que verifica si una palabra se encuentre dentro de alguno de los
	 * mensajes del usuario.
	 * 
	 * @param str  El parametro str corresponde a la palabra que se desea buscar.
	 * @param user El parametro user corresponde al dato usuario en que se buscara
	 *             una palabra en su lista Usuario.
	 * @return El numero -1 si la palabra se encuentra, sino el numero -1 en caso
	 *         contrario.
	 */
	public static int SearchDateUser(usuario user, String str) {
		for (int cont = 0; cont < user.GetUsuario().length; cont++) {
			String[] dato = user.GetUsuario()[cont].split(" ");
			if (Buscar(dato, str) == 1) {
				return 1;
			}
		}
		return -1;
	}

	// Cierre de metodo
	/**
	 * Metodo que imprime por pantalla y agrega mensajes o datos a la lista de
	 * mensajes de log, segun sea el caso.
	 * 
	 * @param Chat       El parametro Chat corresponde a dato chat que cual se le
	 *                   extraera algun mensaje que responda al usuario.
	 * @param Log        El parametro Log corresponde al dato log al cual se le
	 *                   agregaran datos a su lista Log.
	 * @param Aleatorio  El parametro Aleatorio corresponde al dato seed para
	 *                   determinar la columna de la matriz Chat para obtener el
	 *                   mensaje.
	 * @param calendario El parametro calendario corresponde al dato fecha la cual
	 *                   sera agregada a la lista Log.
	 * @param number     El parametro number corresponde valor de la fila de la
	 *                   matriz Chat que se obtendra el mensaje.
	 * @param mensaje    El parametro mensaje corresponde a un mensaje escrito por
	 *                   pantalla el cual puede ser agrega a la lista Log.
	 * @param digito     El parametro digito determina los casos en que se considera
	 *                   el mensaje de usuario o se considera la respuesta del
	 *                   chatbot.
	 * @return El dato log con los datos correspondientes, segun el caso, a su lista
	 *         Log.
	 */
	public static log PrintLogChat(chat Chat, log Log, seed Aleatorio, fecha calendario, int number, int digito,
			String mensaje) {
		if ((digito == 0) || (digito == 2)) {
			Log.AppendLog(mensaje);
			Log.AppendLog(calendario.GetDate());
			System.out.println(calendario.GetDate());
		}
		if ((digito == 0) || (digito != 2)) {
			Log.AppendLog(Chat.GetResponsesChat(number, Aleatorio.GetSeed()));
			Log.AppendLog(calendario.GetDate());
			System.out.println(Chat.GetResponsesChat(number, Aleatorio.GetSeed()));
			System.out.println(calendario.GetDate());
		}
		return Log;
	}

	// Cierre de metodo
	/**
	 * Metodo principal que entrega instrucciones por pantalla y posee las
	 * funcionalidades y condiciones para el uso del chatbot y envio de mensajes.
	 * 
	 * @param args El parametro args corresponde a la inicializacion del metodo.
	 */
	public static void main(String[] args) {
		chat Chat = new chat();
		log Log = new log();
		usuario User = new usuario();
		seed Aleatorio = new seed();
		fecha calendario = new fecha();
		System.out.println("******************************BIENVENIDO AL CHATBOT THOR******************************");
		System.out.println("Chatbot Thor puede conversar brevemente sobre videojuegos y consolas.");
		System.out.println("Indicaciones:\n");
		System.out.println(
				"	1) Para iniciar el chatbot, debe ingresar !beginDialog seed, donde seed es un valor numerico");
		System.out.println(
				"	   que determina un comportamiento aleatorio del chatbot. Si este se omite, el chatbot va a");
		System.out.println(
				"	   tener un comportamiento predeterminado. Asegurece tambien de que si quiere iniciar una nueva");
		System.out.println("	   conversacion, debe finalizar la conversacion actual.\n");
		System.out.println("	2) Para finalizar el chatbot, debe ingresar !endDialog.\n");
		System.out.println(
				"	3) Para guardar la conversacion con el chatbot, debe ingresar !saveLog. La conversacion se va a");
		System.out.println(
				"	   guardar en un archivo de texto donde su nombre va a ser la marca de tiempo actual de la");
		System.out.println(
				"	   conversacion con '.log'. El archivo se va a encontrar en el carpeta que se encuentre el programa.\n");
		System.out
				.println("	4) Para cargar una conversacion anterior, debe ingresar !loadDialog NombreArchivo, donde");
		System.out
				.println("	   NombreArchivo es el nombre del archivo en que se guardo una conversacion anterior.\n");
		System.out.println(
				"	5) Para evaluar tanto el chatbot como al usuario, debe ingresar !rate NotaChatbot NotaUsuario,");
		System.out
				.println("	   donde estos 2 ultimos son numeros. La evaluacion del se debe dar entre 0 y 5, donde 0");
		System.out.println("	   corresponde a que no se puede evaluar.\n");
		System.out.println("	6) Para finalizar el programa, ingrese !finish_program.\n");
		System.out.println(
				"	7) Todo mensaje que inicie con ! se considera una funcionalidad del chatbot, por tanto los mensajes");
		System.out.println(
				"	   directos al chatbot no deben iniciar con estos a no ser que sean las funcionalidades anteriores.\n");
		System.out.println(
				"	8) Los mensajes que se envien al chatbot no deben ser ni muy breves ni muy extensos, utilizando");
		System.out.println(
				"	   algunas palabras que el mismo chatbot envie. Por ejemplo: si el chatbot dice '¿que edad tiene?',");
		System.out.println("	   el usuario puede responder 'tengo 20...'  o 'mi edad es 20...'\n");
		System.out.println(
				"	9) Puede preguntar a Thor si conoce varios juegos o cuantos juegos conoce, a lo que usted despues");
		System.out.println("	   debe solicitarle la respuesta.\n");
		System.out.println(
				"	10)Si escribe mal alguna funcionalidad, el programa le advertira. Si se trata de un mensaje que no");
		System.out.println("	   puede entender el chatbot, el chatbot le advertira.\n\n\n");
		Scanner sc = new Scanner(System.in);
		String mensaje;
		boolean finish = true;
		while (finish == true) {
			System.out.print("Usuario: ");
			mensaje = sc.nextLine();
			String[] msg = mensaje.split(" ");
			if (msg.length >= 1) {
				Random random = new Random();
				if ("!beginDialog".equals(msg[0]) == true) {
					if (("null".equals(Log.GetLog()[0]) == true) || (Log.Encontrar_Dato("!endDialog") == 1)) {
						Log.AppendLog("!beginDialog");
						int saludo = 2;
						if ((Integer.parseInt(calendario.Get_Hour()) >= 12)
								&& (Integer.parseInt(calendario.Get_Hour()) < 20)) {
							saludo = 1;
						}
						if ((Integer.parseInt(calendario.Get_Hour()) >= 4)
								&& (Integer.parseInt(calendario.Get_Hour()) < 12)) {
							saludo = 0;
						}
						if ((msg.length < 2) || ((msg.length >= 2) && (IsNumber(msg[1]) == -1))) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, saludo, 1, "");
						} else {
							Aleatorio.GenerarSeed(msg[1]);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, saludo, 1, "");
						}
					} else {
						System.out.println("Para comenzar el chatbot, debe terminar la conversacion anterior.");
					}
				} else if ("!endDialog".equals(msg[0]) == true) {
					System.out.println(Chat.GetResponsesChat(16, Aleatorio.GetSeed()) + User.GetNombre() + ".");
					Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
							Chat.GetResponsesChat(16, Aleatorio.GetSeed()) + User.GetNombre() + ".");
					Log.AppendLog("!endDialog");
				} else if ("!saveLog".equals(msg[0]) == true) {
					String Fecha = calendario.Get_Year() + "-" + calendario.Get_Month() + "-" + calendario.Get_Day()
							+ "_" + calendario.Get_Hour() + "-" + calendario.Get_Minute() + ".log";
					Log.Guardar_archivo(Fecha);
				} else if ("!loadLog".equals(msg[0]) == true) {
					if (msg.length > 1) {
						Log = Log.Leer_archivo(Log, msg[1]);
					} else {
						System.out.println("Los parametros son insuficientes.");
					}
				} else if ("!rate".equals(msg[0]) == true) {
					if (msg.length > 2) {
						if ((IsNumber(msg[1]) == 1) && (Integer.parseInt(msg[1]) <= 5) && (Integer.parseInt(msg[1]) > 0)
								&& (IsNumber(msg[2]) == 1)
								&& (Integer.parseInt(msg[2]) <= 5) && (Integer.parseInt(msg[2]) > 0)) {
							String evaluacion = "Nota_Chatbot: " + msg[1] + " Nota_Usuario: " + msg[2];
							System.out.println(evaluacion);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, evaluacion);
						} else if ((IsNumber(msg[1]) == 1) && (Integer.parseInt(msg[1]) <= 5)
								&& (Integer.parseInt(msg[1]) > 0) && (IsNumber(msg[2]) == 1)
								&& (Integer.parseInt(msg[2]) == 0)) {
							String evaluacion = "Nota_Chatbot: " + msg[1] + " Nota_Usuario: " + "Indeterminado";
							System.out.println(evaluacion);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, evaluacion);
						} else if ((IsNumber(msg[1]) == 1) && (Integer.parseInt(msg[1]) == 0) && (IsNumber(msg[2]) == 1)
								&& (Integer.parseInt(msg[2]) <= 5)
								&& (Integer.parseInt(msg[2]) > 0)) {
							String evaluacion = "Nota_Chatbot: " + "Indeterminado" + " Nota_Usuario: " + msg[2];
							System.out.println(evaluacion);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, evaluacion);
						} else if ((IsNumber(msg[1]) == 1) && (Integer.parseInt(msg[1]) == 0) && (IsNumber(msg[2]) == 1)
								&& (Integer.parseInt(msg[2]) == 0)) {
							String evaluacion = "Nota_Chatbot: " + "Indeterminado" + " Nota_Usuario: "
									+ "Indeterminado";
							System.out.println(evaluacion);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, evaluacion);
						} else {
							System.out.println("Debe ingresar las evaluaciones correctamente.");
						}
					} else {
						System.out.println("Los parametros son insuficientes.");
					}
				} else if (Buscar(msg, "!finish_program") == 1) {
					finish = false;
				} else if ("!".equals(msg[0].substring(0, 1)) == false) {
					if ((Buscar(msg, "buena") == 1) || (Buscar(msg, "hola") == 1) || (Buscar(msg, "buenas") == 1)
							|| (Buscar(msg, "buenos") == 1) || (Buscar(msg, "bueno") == 1)
							|| (Buscar(msg, "hola") == 1) || (Buscar(msg, "buenas") == 1)) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 17, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "bien") == 1) || (Buscar(msg, "genial") == 1)
							|| (Buscar(msg, "estupendo") == 1) || (Buscar(msg, "excelente") == 1)) &&
							((Buscar(msg, "no") == -1) || (Buscar(msg, "mal") == -1) || (Buscar(msg, "ni") == -1))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 4, 0, "Usuario: " + mensaje);
					} else if ((((Buscar(msg, "bien") == 1) || (Buscar(msg, "genial") == 1)
							|| (Buscar(msg, "estupendo") == 1) || (Buscar(msg, "excelente") == 1)) &&
							((Buscar(msg, "no") == 1) || (Buscar(msg, "mal") == 1) || (Buscar(msg, "ni") == 1)))
							|| ((Buscar(msg, "mal") == 1) || (Buscar(msg, "pesimo") == 1) ||
									((Buscar(msg, "mas") == 1) && (Buscar(msg, "o") == 1)
											&& (Buscar(msg, "menos") == 1)))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 5, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "no") == 1) || (Buscar(msg, "nunca") == 1) || (Buscar(msg, "jamas") == 1))
							&&
							((Buscar(msg, "juego") == 1) || (Buscar(msg, "juegos") == 1)
									|| (Buscar(msg, "videojuego") == 1) || (Buscar(msg, "videojuegos") == 1))
							&&
							((Buscar(msg, "wii") == -1) && (Buscar(msg, "xbox") == -1)
									&& ((Buscar(msg, "ps") == -1) || (Buscar(msg, "play") == -1)))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "si") == 1) || (Buscar(msg, "siempre") == 1) || (Buscar(msg, "obvio") == 1)
							|| (Buscar(msg, "veces") == 1)) &&
							((Buscar(msg, "juego") == 1) || (Buscar(msg, "juegos") == 1)
									|| (Buscar(msg, "videojuego") == 1) || (Buscar(msg, "videojuegos") == 1))
							&&
							((Buscar(msg, "wii") == -1) && (Buscar(msg, "xbox") == -1)
									&& ((Buscar(msg, "ps") == -1) || (Buscar(msg, "play") == -1)))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 6, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "ninguna") == 1) || (Buscar(msg, "ninguno") == 1)
							|| ((Buscar(msg, "no") == 1) && ((Buscar(msg, "ni") == 1)
									|| (Buscar(msg, "esas") == 1) || (Buscar(msg, "esos") == 1)
									|| (Buscar(msg, "ellos") == 1) || (Buscar(msg, "ellas") == 1)
									|| (Buscar(msg, "dos") == 1) || (Buscar(msg, "tres") == 1)
									|| (Buscar(msg, "2") == 1) || (Buscar(msg, "3") == 1)))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 11, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "Pc") == 1) || (Buscar(msg, "computador") == 1)
							|| (Buscar(msg, "computadora") == 1) || (Buscar(msg, "notebook") == 1)
							|| (Buscar(msg, "laptop") == 1)) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "consola") == 1) || (Buscar(msg, "dos") == 1) || (Buscar(msg, "2") == 1)
							|| (Buscar(msg, "ambas") == 1) || (Buscar(msg, "ambos") == 1)
							|| ((Buscar(msg, "y") == 1) && (Buscar(msg, "consola") == 1)))
							&& (Buscar(msg, "no") == -1)) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 7, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "wii") == 1) && (Buscar(msg, "xbox") == 1)
							&& ((Buscar(msg, "ps") == 1) || (Buscar(msg, "play") == 1))) || (Buscar(msg, "todos") == 1)
							||
							(Buscar(msg, "todas") == 1) || (Buscar(msg, "tres") == 1) || (Buscar(msg, "3") == 1)) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "wii") == 1) && (Buscar(msg, "xbox") == 1)
							&& ((Buscar(msg, "ps") == -1) || (Buscar(msg, "play") == -1))) {
						;
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 9, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "wii") == 1) && (Buscar(msg, "xbox") == -1)
							&& ((Buscar(msg, "ps") == 1) || (Buscar(msg, "play") == 1))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 10, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "wii") == -1) && (Buscar(msg, "xbox") == 1)
							&& ((Buscar(msg, "ps") == 1) || (Buscar(msg, "play") == 1))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 8, 0, "Usuario: " + mensaje);
					} else if ((Buscar(msg, "wii") == -1) && (Buscar(msg, "xbox") == -1)
							&& ((Buscar(msg, "ps") == 1) || (Buscar(msg, "play") == 1))) {
						User.AppendUsuario(mensaje);
						if ((SearchDateUser(User, "wii") == 1) && (SearchDateUser(User, "xbox") == 1)) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
						} else if ((SearchDateUser(User, "wii") == 1) && (SearchDateUser(User, "xbox") == -1)) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 10, 0, "Usuario: " + mensaje);
						} else {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 8, 0, "Usuario: " + mensaje);
						}
					} else if ((Buscar(msg, "wii") == -1) && (Buscar(msg, "xbox") == 1)
							&& ((Buscar(msg, "ps") == -1) || (Buscar(msg, "play") == -1))) {
						User.AppendUsuario(mensaje);
						if ((SearchDateUser(User, "wii") == 1)
								&& ((SearchDateUser(User, "play") == 1) || (SearchDateUser(User, "ps") == 1))) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
						} else if ((SearchDateUser(User, "wii") == 1)
								&& ((SearchDateUser(User, "play") == -1) || (SearchDateUser(User, "ps") == -1))) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 9, 0, "Usuario: " + mensaje);
						} else {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 8, 0, "Usuario: " + mensaje);
						}
					} else if ((Buscar(msg, "wii") == 1) && (Buscar(msg, "xbox") == -1)
							&& ((Buscar(msg, "ps") == -1) || (Buscar(msg, "play") == -1))) {
						User.AppendUsuario(mensaje);
						if ((SearchDateUser(User, "xbox") == 1)
								&& ((SearchDateUser(User, "play") == 1) || (SearchDateUser(User, "ps") == 1))) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 12, 0, "Usuario: " + mensaje);
						} else if ((SearchDateUser(User, "xbox") == 1)
								&& ((SearchDateUser(User, "play") == -1) || (SearchDateUser(User, "ps") == -1))) {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 9, 0, "Usuario: " + mensaje);
						} else {
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 10, 0, "Usuario: " + mensaje);
						}
					} else if (((Buscar(msg, "conoces?") == 1) || (Buscar(msg, "conoces") == 1)
							|| (Buscar(msg, "¿conoces") == 1))
							&& ((Buscar(msg, "juego") == 1)
									|| (Buscar(msg, "juegos") == 1) || (Buscar(msg, "juego?") == 1)
									|| (Buscar(msg, "juegos?") == 1) || (Buscar(msg, "videojuego") == 1)
									|| (Buscar(msg, "videojuegos") == 1) || (Buscar(msg, "videojuego?") == 1)
									|| (Buscar(msg, "videojuegos?") == 1))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 14, 0, "Usuario: " + mensaje);
					} else if (((Buscar(msg, "responde") == 1) || (Buscar(msg, "respondeme") == 1)
							|| (Buscar(msg, "respondas") == 1) || (Buscar(msg, "responderme") == 1)
							|| (Buscar(msg, "responderme?") == 1) || (Buscar(msg, "responder") == 1)
							|| (Buscar(msg, "responder?") == 1) || (Buscar(msg, "respuesta") == 1)
							|| (Buscar(msg, "respuesta?") == 1))
							&& (((SearchDateUser(User, "conoces?") == 1) || (SearchDateUser(User, "conoces") == 1)
									|| (SearchDateUser(User, "¿conoces") == 1))
									&& ((SearchDateUser(User, "juego") == 1) || (SearchDateUser(User, "juego?") == 1) ||
											(SearchDateUser(User, "juegos") == 1)
											|| (SearchDateUser(User, "juegos?") == 1)
											|| (SearchDateUser(User, "videojuego") == 1) ||
											(SearchDateUser(User, "videojuego?") == 1)
											|| (SearchDateUser(User, "videojuegos") == 1)
											|| (SearchDateUser(User, "videojuegos?") == 1)))) {
						User.AppendUsuario(mensaje);
						Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 15, 0, "Usuario: " + mensaje);
					} else {
						if (msg.length >= 2) {
							if ("soy".equals(msg[0]) == true) {
								String name = "";
								for (int cont = 1; cont < msg.length; cont++) {
									name = name + msg[cont];
								}
								User.ChangeNombre(name);
								User.AppendUsuario(mensaje);
								Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, "Usuario: " + mensaje);
								System.out.println(Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
										+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
								Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
										Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
												+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
							} else if (("tengo".equals(msg[0]) == true) && (IsNumber(msg[1]) == 1)) {
								int year = Integer.parseInt(msg[1]);
								User.ChangeEdad(year);
								User.AppendUsuario(mensaje);
								Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, "Usuario: " + mensaje);
								System.out.println(Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
										+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
								Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
										Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
												+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
							} else if (msg.length >= 3) {
								if ((("yo".equals(msg[0]) == true) && ("soy".equals(msg[1]) == true)) ||
										(("me".equals(msg[0]) == true) && ("llamo".equals(msg[1]) == true))) {
									String name = "";
									for (int cont = 2; cont < msg.length; cont++) {
										name = name + msg[cont];
									}
									User.ChangeNombre(name);
									User.AppendUsuario(mensaje);
									Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, "Usuario: " + mensaje);
									System.out.println(Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
											+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
									Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
											Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
													+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
								} else if (("yo".equals(msg[0]) == true) && ("tengo".equals(msg[1]) == true)
										&& (IsNumber(msg[2]) == 1)) {
									int year = Integer.parseInt(msg[2]);
									User.ChangeEdad(year);
									User.AppendUsuario(mensaje);
									Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2, "Usuario: " + mensaje);
									System.out.println(Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
											+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
									Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
											Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
													+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
								} else if (msg.length >= 4) {
									if ((("yo".equals(msg[0]) == true) && ("me".equals(msg[1]) == true)
											&& ("llamo".equals(msg[2]) == true)) ||
											(("mi".equals(msg[0]) == true) && ("nombre".equals(msg[1]) == true)
													&& ("es".equals(msg[2]) == true))) {
										String name = "";
										for (int cont = 3; cont < msg.length; cont++) {
											name = name + msg[cont];
										}
										User.ChangeNombre(name);
										User.AppendUsuario(mensaje);
										Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
												"Usuario: " + mensaje);
										System.out.println(Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
												+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
										Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
												Chat.GetResponsesChat(18, Aleatorio.GetSeed()) + name
														+ Chat.GetResponsesChat(19, Aleatorio.GetSeed()));
									} else if (("mi".equals(msg[0]) == true)
											&& ("edad".equals(msg[1]) == true) & ("es".equals(msg[2]) == true)
											&& (IsNumber(msg[3]) == 1)) {
										int year = Integer.parseInt(msg[3]);
										User.ChangeEdad(year);
										User.AppendUsuario(mensaje);
										Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
												"Usuario: " + mensaje);
										System.out.println(Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
												+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
										Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 0, 2,
												Chat.GetResponsesChat(20, Aleatorio.GetSeed()) + year
														+ Chat.GetResponsesChat(3, Aleatorio.GetSeed()));
									} else {
										User.AppendUsuario(mensaje);
										Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 13, 0,
												"Usuario: " + mensaje);
									}
								} else {
									User.AppendUsuario(mensaje);
									Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 13, 0, "Usuario: " + mensaje);
								}
							} else {
								User.AppendUsuario(mensaje);
								Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 13, 0, "Usuario: " + mensaje);
							}
						} else {
							User.AppendUsuario(mensaje);
							Log = PrintLogChat(Chat, Log, Aleatorio, calendario, 13, 0, "Usuario: " + mensaje);
						}
					}
				} else {
					System.out.println("Error en escritura de parametro o funcionalidad. Vuelva a escribir.");
				}
			} else {
				System.out.println("Error en envio del mensaje. Vuelva a enviar un mensaje.");
			}
		}
	}
	// Cierre de metodo
}
// Cierre de clase