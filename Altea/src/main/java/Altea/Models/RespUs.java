package Altea.Models;

public class RespUs {
    private Long id;
    private String Descripcion;
    private Long id_Usuario;
    private Long id_RespChat;

    public RespUs(Long id, String Descripcion, Long id_Usuario, Long id_RespChat){
        this.id = id;
        this.Descripcion = Descripcion;
        this.id_Usuario = id_Usuario;
        this.id_RespChat = id_RespChat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Long getId_Usuario() {
        return this.id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Long getId_RespChat() {
        return this.id_RespChat;
    }

    public void setId_RespChat(Long id_RespChat) {
        this.id_RespChat = id_RespChat;
    }

}
