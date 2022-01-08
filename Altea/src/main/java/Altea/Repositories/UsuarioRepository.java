package Altea.Repositories;

import java.util.List;
import Altea.Models.Usuario;

public interface UsuarioRepository {
    public int countUsuario();
    public List<Usuario> getAllUsuario();
    public boolean deleteUsuario(long id);
    public Usuario getUsuario(String correo);
    public boolean updateUsuario(Usuario nuevoUsuario);
    public Usuario getUserByToken(String token);
    public Usuario logIn(Usuario user);
    public String logOut(Usuario user);
    public Usuario Login2(String corr, String contra);
    public Usuario createUsuario2(Usuario Usuario);
}
