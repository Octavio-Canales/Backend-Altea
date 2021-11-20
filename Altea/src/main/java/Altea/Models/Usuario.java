package Altea.Models;

public class Usuario {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;
    private int Edad;
    private int loginToken;
    private Long id_chatbot;

    public Usuario(Long id, String Nombre, String Apellido, int Edad, String Correo, String Contrasenia, int loginToken, Long id_chatbot){
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Correo = Correo;
        this.Contrasenia = Contrasenia;
        this.loginToken = loginToken;
        this.id_chatbot = id_chatbot;
    }

    public Long getId() {
        return id;
    }

    public void setId(long insertedId) {
        this.id = insertedId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
		return this.Edad;
	}

	public void setEdad(int Edad) {
		this.Edad = Edad;
	}

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public int getLoginToken() {
        return this.loginToken;
    }

    public void setLoginToken(int loginToken) {
        this.loginToken = loginToken;
    }

    public Long getId_chatbot() {
        return this.id_chatbot;
    }

    public void setId_chatbot(Long id_chatbot) {
        this.id_chatbot = id_chatbot;
    }
}
