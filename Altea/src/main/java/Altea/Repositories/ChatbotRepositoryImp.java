package Altea.Repositories;

import Altea.Models.Chatbot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ChatbotRepositoryImp implements ChatbotRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countChatbot() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Chatbot").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Chatbot> getAllChatbot() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Chatbot").executeAndFetch(Chatbot.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Chatbot createChatbot(Chatbot chatbot) {
        try(Connection conn = sql2o.open()){
            Chatbot v1 = conn.createQuery("select * from Chatbot where Nombre=:Nombre").addParameter("Nombre",chatbot.getNombre()).executeAndFetchFirst(Chatbot.class);
            if (v1 == null){
                long insertedId = countChatbot()+1;
                conn.createQuery("insert into Chatbot (ID, Nombre, Descripcion)"+
                        " values (:id, :ChatbotNombre, :ChatbotDescripcion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("ChatbotNombre", chatbot.getNombre())
                        .addParameter("ChatbotDescripcion", chatbot.getDescripcion())
                        .executeUpdate().getKey();
                chatbot.setId(insertedId);
                return chatbot;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteChatbot(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Chatbot WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Chatbot getChatbot(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Descripcion AS Descripcion from Chatbot where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Chatbot.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateChatbot(Chatbot nuevoChatbot){
        String updateSql = "update Chatbot set Nombre = : Nombre, Descripcion = : Descripcion where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Descripcion", nuevoChatbot.getDescripcion())
                .addParameter("Nombre",nuevoChatbot.getNombre())
                .addParameter("id", nuevoChatbot.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
