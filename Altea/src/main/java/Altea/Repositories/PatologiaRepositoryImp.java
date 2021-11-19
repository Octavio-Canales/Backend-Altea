package Altea.Repositories;

import Altea.Models.Patologia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class PatologiaRepositoryImp implements PatologiaRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countPatologia() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Patologia").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Patologia> getAllPatologia() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Patologia").executeAndFetch(Patologia.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Patologia createPatologia(Patologia Patologia) {
        try(Connection conn = sql2o.open()){
            Patologia v1 = conn.createQuery("select * from Patologia where Nombre=:Nombre").addParameter("Nombre",Patologia.getNombre()).executeAndFetchFirst(Patologia.class);
            if (v1 == null){
                long insertedId = countPatologia()+1;
                conn.createQuery("insert into Patologia (ID, Nombre, Descripcion, Recomendacion)"+
                        " values (:id, :PatologiaNombre, :PatologiaDescripcion, :PatologiaRecomendacion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("PatologiaNombre", Patologia.getNombre())
                        .addParameter("PatologiaDescripcion", Patologia.getDescripcion())
                        .addParameter("PatologiaRecomendacion", Patologia.getRecomendacion())
                        .executeUpdate().getKey();
                Patologia.setId(insertedId);
                return Patologia;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deletePatologia(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Patologia WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Patologia getPatologia(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion, Recomendacion AS Recomendacion from Patologia where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Patologia.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updatePatologia(Patologia nuevoPatologia){
        String updateSql = "update Patologia set Nombre = : Nombre, Descripcion = : Descripcion, Recomendacion = : Recomendacion where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Recomendacion", nuevoPatologia.getRecomendacion())
                .addParameter("Descripcion", nuevoPatologia.getDescripcion())
                .addParameter("Nombre",nuevoPatologia.getNombre())
                .addParameter("id", nuevoPatologia.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}