package Altea.Repositories;

import Altea.Models.Sintoma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class SintomaRepositoryImp implements SintomaRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countSintoma() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Sintoma").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Sintoma> getAllSintoma() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Sintoma").executeAndFetch(Sintoma.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Sintoma createSintoma(Sintoma Sintoma) {
        try(Connection conn = sql2o.open()){
            Sintoma v1 = conn.createQuery("select * from Sintoma where Nombre=:Nombre").addParameter("Nombre",Sintoma.getNombre()).executeAndFetchFirst(Sintoma.class);
            if (v1 == null){
                long insertedId = countSintoma()+1;
                conn.createQuery("insert into Sintoma (ID, Nombre, Descripcion)"+
                        " values (:id, :Nombre, :Descripcion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("Nombre", Sintoma.getNombre())
                        .addParameter("Descripcion", Sintoma.getDescripcion())
                        .executeUpdate().getKey();
                Sintoma.setId(insertedId);
                return Sintoma;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteSintoma(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Sintoma WHERE ID = :ID")
            .addParameter("ID", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Sintoma getSintoma(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion from Sintoma where ID=:ID";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("ID", id)
				.executeAndFetchFirst(Sintoma.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateSintoma(Sintoma nuevoSintoma){
        String updateSql = "update Sintoma set Nombre = : Nombre, Descripcion = : Descripcion where ID = :ID";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoSintoma.getDescripcion())
                .addParameter("Nombre",nuevoSintoma.getNombre())
                .addParameter("ID", nuevoSintoma.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
