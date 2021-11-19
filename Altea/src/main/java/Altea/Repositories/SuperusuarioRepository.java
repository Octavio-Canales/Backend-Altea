package Altea.Repositories;

import java.util.List;
import Altea.Models.Superusuario;

public interface SuperusuarioRepository {
    public int countSuperusuario();
    public List<Superusuario> getAllSuperusuario();
    public Superusuario createSuperusuario(Superusuario superusuario);
    public boolean deleteSuperusuario(long id);
    public Superusuario getSuperusuario(long id);
    public boolean updateSuperusuario(Superusuario nuevoSuperusuario);
    public Superusuario getUserByToken(String token);
    public Superusuario logIn(Superusuario user);
    public String logOut(Superusuario user);
}
