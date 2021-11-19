package Altea.Repositories;

import java.util.List;
import Altea.Models.Noticia;

public interface NoticiaRepository {
    public int countNoticia();
    public List<Noticia> getAllNoticia();
    public Noticia createNoticia(Noticia noticia);
    public boolean deleteNoticia(long id);
    public Noticia getNoticia(long id);
    public boolean updateNoticia(Noticia nuevoNoticia);
}
