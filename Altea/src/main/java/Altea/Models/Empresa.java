package Altea.Models;

public class Empresa {
    private Long id;
    private String Nombre;
    private String Correo;
    private String Contrasenia;
    private int loginToken;

    public Empresa(Long id, String Nombre, String Correo, String Contrasenia, int loginToken){
        this.id = id;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Contrasenia = Contrasenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

