package Altea.Repositories;

import Altea.Models.RespChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RespChatRepositoryImp implements RespChatRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countRespChat() {
        int total = 0;
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery("SELECT COUNT(*) FROM RespChat").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<RespChat> getAllRespChat() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM RespChat")
                    .executeAndFetch(RespChat.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RespChat createRespChat(RespChat RespChat) {
        try (Connection conn = sql2o.open()) {
            RespChat v1 = conn.createQuery("select * from RespChat where ID=:ID")
                    .addParameter("Nombre", RespChat.getId()).executeAndFetchFirst(RespChat.class);
            if (v1 == null) {
                long insertedId = countRespChat() + 1;
                conn.createQuery("insert into RespChat (ID, Descripcion, id_chatbot)"
                        + " values (:id, :RespChatNombre, :RespChatDescripcion, :RespChat_id_chatbot)")
                        .addParameter("id", insertedId).addParameter("RespChatDescripcion", RespChat.getDescripcion())
                        .addParameter("RespChat_id_chatbot", RespChat.getId_chatbot()).executeUpdate().getKey();
                RespChat.setId(insertedId);
                return RespChat;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean deleteRespChat(long id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM RespChat WHERE ID = :id").addParameter("id", id).executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public RespChat getRespChat(long id) {
        String sql = "select ID AS ID, Descripcion AS Descripcion, id_chatbot AS id_chatbot from RespChat where ID=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(RespChat.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateRespChat(RespChat nuevoRespChat) {
        String updateSql = "update RespChat set Descripcion = : Descripcion,  id_chatbot = : id_chatbot where id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql).addParameter("id", nuevoRespChat.getId())
                    .addParameter("Descripcion", nuevoRespChat.getDescripcion())
                    .addParameter("id_chatbot", nuevoRespChat.getId_chatbot()).executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
