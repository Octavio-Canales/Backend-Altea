package Altea.Repositories;

import Altea.Models.RespUs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RespUsRepositoryImp implements RespUsRepository {

    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countRespUs() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM RespUs").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<RespUs> getAllRespUs() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM RespUs").executeAndFetch(RespUs.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RespUs createRespUs(RespUs RespUs) {
        try(Connection conn = sql2o.open()){
            RespUs v1 = conn.createQuery("select * from RespUs where ID=:ID").addParameter("ID",RespUs.getId()).executeAndFetchFirst(RespUs.class);
            if (v1 == null){
                long insertedId = countRespUs()+1;
                conn.createQuery("insert into RespUs (ID, Descripcion, id_RespChat, id_Usuario )"+
                        " values (:id, :Descripcion, :id_RespChat, :id_Usuario)") 
                        .addParameter("id",  insertedId)             
                        .addParameter("Descripcion", RespUs.getDescripcion())
                        .addParameter("id_ResChat", RespUs.getId_RespChat())
                        .addParameter("id_Usuario", RespUs.getId_Usuario())
                        .executeUpdate().getKey();
                RespUs.setId(insertedId);
                return RespUs;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteRespUs(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM RespUs WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public RespUs getRespUs(long id){
		String sql = "select ID AS ID, Descripcion AS Descripción, id_RespChat AS id_RespChat, id_Usuario AS id_Usuario from RespUs where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(RespUs.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateRespUs(RespUs nuevoRespUs){
        String updateSql = "update RespUs set Descripcion = : Descripcion, id_RespChat AS id_RespChat, id_Usuario AS id_Usuario where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoRespUs.getDescripcion())
                .addParameter("id_RespChat", nuevoRespUs.getId_RespChat())
                .addParameter("id_Usuario", nuevoRespUs.getId_Usuario())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    
}
