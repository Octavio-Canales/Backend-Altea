package Altea.Repositories;

import java.util.List;
import Altea.Models.Patologia;

public interface PatologiaRepository {
    public int countPatologia();
    public List<Patologia> getAllPatologia();
    public Patologia createPatologia(Patologia patologia);
    public boolean deletePatologia(long id);
    public Patologia getPatologia(long id);
    public boolean updatePatologia(Patologia nuevoPatologia);
}
