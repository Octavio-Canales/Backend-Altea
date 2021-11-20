package Altea.Repositories;

import Altea.Models.Estadistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class EstadisticaRepositoryImp implements EstadisticaRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countEstadistica() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Estadistica").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Estadistica> getAllEstadistica() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Estadistica").executeAndFetch(Estadistica.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estadistica createEstadistica(Estadistica Estadistica) {
        try(Connection conn = sql2o.open()){
            Estadistica v1 = conn.createQuery("select * from Estadistica where Nombre=:Nombre").addParameter("Nombre",Estadistica.getNombre()).executeAndFetchFirst(Estadistica.class);
            if (v1 == null){
                long insertedId = countEstadistica()+1;
                conn.createQuery("insert into Estadistica (ID, Nombre, Descripcion)"+
                        " values (:id, :EstadisticaNombre, :EstadisticaDescripcion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("EstadisticaNombre", Estadistica.getNombre())
                        .addParameter("EstadisticaDescripcion", Estadistica.getDescripcion())
                        .executeUpdate().getKey();
                Estadistica.setId(insertedId);
                return Estadistica;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteEstadistica(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Estadistica WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Estadistica getEstadistica(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion from Estadistica where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Estadistica.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateEstadistica(Estadistica nuevoEstadistica){
        String updateSql = "update Estadistica set Nombre = : Nombre, Descripcion = : Descripcion where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoEstadistica.getDescripcion())
                .addParameter("Nombre",nuevoEstadistica.getNombre())
                .addParameter("id", nuevoEstadistica.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
