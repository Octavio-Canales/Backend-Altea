package Altea.Repositories;

import Altea.Models.Noticia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class NoticiaRepositoryImp implements NoticiaRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countNoticia() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Noticia").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Noticia> getAllNoticia() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Noticia").executeAndFetch(Noticia.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Noticia createNoticia(Noticia Noticia) {
        try(Connection conn = sql2o.open()){
            Noticia v1 = conn.createQuery("select * from Noticia where Nombre=:Nombre").addParameter("Nombre",Noticia.getNombre()).executeAndFetchFirst(Noticia.class);
            if (v1 == null){
                long insertedId = countNoticia()+1;
                conn.createQuery("insert into Noticia (ID, Nombre, Descripcion)"+
                        " values (:id, :NoticiaNombre, :NoticiaDescripcion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("NoticiaNombre", Noticia.getNombre())
                        .addParameter("NoticiaDescripcion", Noticia.getDescripcion())
                        .executeUpdate().getKey();
                Noticia.setId(insertedId);
                return Noticia;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteNoticia(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Noticia WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Noticia getNoticia(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion from Noticia where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Noticia.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateNoticia(Noticia nuevoNoticia){
        String updateSql = "update Noticia set Nombre = : Nombre, Descripcion = : Descripcion where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoNoticia.getDescripcion())
                .addParameter("Nombre",nuevoNoticia.getNombre())
                .addParameter("id", nuevoNoticia.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
