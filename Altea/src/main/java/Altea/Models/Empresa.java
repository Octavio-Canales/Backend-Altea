package Altea.Models;

public class Empresa {
    private int id;
    private String Nombre;
    private String Correo;
    private String Contrasenia;
    private int loginToken;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
		return loginToken;
	}

	public void setLoginToken(int loginToken) {
		this.loginToken = loginToken;
	}
}

