package Altea.Models;

public class Patologia {
    private Long id;
    private String Nombre;
    private String Descripcion;
    private String Recomendacion;

    public Patologia(Long id, String Nombre, String Descripcion, String Recomendacion){
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Recomendacion = Recomendacion;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRecomendacion() {
        return Recomendacion;
    }

    public void setRecomendacion(String Recomendacion) {
        this.Recomendacion = Recomendacion;
    }
}
