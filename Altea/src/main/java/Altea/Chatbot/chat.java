package Altea.Chatbot;

import java.util.ArrayList;

/**
 * Esta clase define una matriz de mensajes posibles Chat para entregar.
 */
public class chat {
	// Campos de la clase
	private String[][] Chat = {
			{ "Thor: Buenos dias usuario, soy Thor.", "Thor: Buenos dias usuario, me llamo Thor.",
					"Thor: Buenos dias usuario, yo soy Thor." },
			{ "Thor: Buenas tardes usuario, soy Thor.", "Thor: Buenas tardes usuario, me llamo Thor.",
					"Thor: Buenas tardes usuario, yo soy Thor." },
			{ "Thor: Buenas noches, soy Thor.", "Thor: Buenas noches usuario, me llamo Thor.",
					"Thor: Buenos dias usuario, yo soy Thor." },
			{ ". ¿Como ha estado?", ". ¿Como esta?", ". ¿Como se encuentra?" },
			{ "Thor: Genial, entonces para comenzar ¿usted juega videojuegos?",
					"Thor: Que bien, bueno, comenzando con la conversacion ¿ha jugado videojuegos?",
					"Thor: Me alegro por usted. Bueno, tengo algo que preguntarle ¿juega videojuegos?" },
			{ "Thor: Que lastima, intentare subirle el animo con la conversacion. Digame ¿usted ha jugado videojuegos?",
					"Thor: Que mal, bueno, intentare que nuestra conversacion lo anime.¿juega videojuegos?",
					"Thor: Espero usted se recupere. Lo que puedo hacer ahora por usted es conversar e intentar animarlo. para empezar ¿usted ha jugado videojuegos?" },
			{ "Thor: ¿Usted juega en consola o PC?", "Thor: ¿Y usted prefiere juegar en PC o en alguna consola?",
					"Thor: Comprendo, ¿y utiliza PC o consola?" },
			{ "Thor: ¿Que tipo de consola?¿PS, Wii o Xbox?", "Thor: ¿Play Station, Wii o Xbox?",
					"Thor: ¿Y usted juega en PS, Wii o Xbox?" },
			{ "Thor: ¿Y en la Wii?", "Thor: ¿Y juega en la Wii?", "Thor: ¿Y utiliza la Wii?" },
			{ "Thor: ¿Y en la PS?", "Thor: ¿Y en la Play Station?", "Thor: ¿Y juega en la PS?" },
			{ "Thor: ¿Y en la Xbox?", "Thor: ¿Y juega en la Xbox?", "Thor: ¿Y utiliza la Xbox?" },
			{ "Thor: Supongo que debe jugar en otro dispositivo.",
					"Thor: Entonces usted tal vez juega en otro dispositivo.",
					"Thor: Vaya, parece que usted juega en otra clase de dispositivo." },
			{ "Thor: Comprendo.", "Thor: Entiendo.", "Thor: Ya veo." },
			{ "Thor: Disculpe, no entendi lo que me dijo.", "Thor: Perdon pero no entiendo lo que me dice.",
					"Thor: No comprendo lo que usted me dice." },
			{ "Thor: Le respondere mas adelante.", "Thor: Mas tarde le respondo.", "Thor: Despues le respondere eso." },
			{ "Thor: Conosco muchos juegos, de los que me acuerdo ahora son Minecraft, Fornite y Cuphead",
					"Thor: Hay varios juegos, de los cuales conosco Cuphead, Minecraft y Fornite.",
					"Thor: Son muchos, pero de los que me acuerdo ahora son Fornite, Cuphead y Minecraft." },
			{ "Thor: Fue un agrado conversar con usted ", "Thor: Hasta la proxima. Espero volvamos a hablar ",
					"Thor: Hasta pronto. Espero haber sido de su agrado " },
			{ "Thor: ¿Cual es su nombre?", "Thor: ¿Como se llama usted?", "Thor: Digame su nombre por favor." },
			{ "Thor: Encantado ", "Thor: Un gusto ", "Thor: Un placer " },
			{ ". Digame su edad por favor.", ". ¿Cual es su edad?", ". ¿Que edad tiene?" },
			{ "Thor: Es una buena edad tener ", "Thor: Disfrute su juventud, aprovechando que tiene de edad ",
					"Thor: Asi que tiene " } };

	/**
	 * Metodo que devuelve la matriz de de mensajes del chatbot.
	 * 
	 * @return La lista de strings correspondiente a la lista de mensajes del
	 *         usuario.
	 */
	public String[][] GetChat() {
		return this.Chat;
	}

	// Cierre de metodo
	/**
	 * Metodo que entrega el mensaje en una posicion de la matriz Chat.
	 * 
	 * @param Chat    El parametro Chat corresponde al parametro chat al cual se le
	 *                obtendra un mensaje de su matriz.
	 * @param pos_fil El parametro pos_fil indica la fila en que se encuentra el
	 *                mensaje a obtener.
	 * @param pos_col El parametro pos_col indica la columna en que se encuentra el
	 *                mensaje a obtener.
	 * @return El string correspondiente al mensaje que se obtiene de la matriz
	 *         Chat.
	 */
	public String GetResponsesChat(int pos_fil, int pos_col) {
		return this.Chat[pos_fil][pos_col];
	}
	// Cierre de metodo
}
// Cierre de clase