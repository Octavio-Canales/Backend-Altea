package Altea.Repositories;

import Altea.Models.Consejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class ConsejoRepositoryImp implements ConsejoRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countConsejo() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Consejo").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Consejo> getAllConsejo() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Consejo").executeAndFetch(Consejo.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Consejo createConsejo(Consejo Consejo) {
        try(Connection conn = sql2o.open()){
            Consejo v1 = conn.createQuery("select * from Consejo where Nombre=:Nombre").addParameter("Nombre",Consejo.getNombre()).executeAndFetchFirst(Consejo.class);
            if (v1 == null){
                long insertedId = countConsejo()+1;
                conn.createQuery("insert into Consejo (ID, Nombre, Descripcion)"+
                        " values (:id, :ConsejoNombre, :ConsejoDescripcion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("ConsejoNombre", Consejo.getNombre())
                        .addParameter("ConsejoDescripcion", Consejo.getDescripcion())
                        .executeUpdate().getKey();
                Consejo.setId(insertedId);
                return Consejo;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteConsejo(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Consejo WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Consejo getConsejo(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion from Consejo where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Consejo.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateConsejo(Consejo nuevoConsejo){
        String updateSql = "update Consejo set Nombre = : Nombre, Descripcion = : Descripcion where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoConsejo.getDescripcion())
                .addParameter("Nombre",nuevoConsejo.getNombre())
                .addParameter("id", nuevoConsejo.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
