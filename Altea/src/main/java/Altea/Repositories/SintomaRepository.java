package Altea.Repositories;

import java.util.List;
import Altea.Models.Sintoma;

public interface SintomaRepository {
    public int countSintoma();
    public List<Sintoma> getAllSintoma();
    public Sintoma createSintoma(Sintoma sintoma);
    public boolean deleteSintoma(long id);
    public Sintoma getSintoma(long id);
    public boolean updateSintoma(Sintoma nuevoSintoma);
}
