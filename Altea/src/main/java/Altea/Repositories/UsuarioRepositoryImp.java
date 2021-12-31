package Altea.Repositories;

import Altea.Models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countUsuario() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Usuario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario").executeAndFetch(Usuario.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario createUsuario(Usuario Usuario) {
        try(Connection conn = sql2o.open()){
            Usuario v1 = conn.createQuery("select * from Usuario where Correo=:Correo").addParameter("Correo",Usuario.getCorreo()).executeAndFetchFirst(Usuario.class);
            if (v1 == null){
                int insertedId = countUsuario()+1;
                conn.createQuery("insert into Usuario (ID, Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)"+
                        " values (:id, :Nombre, :Apellido, :edad, :Correo, :Contrasenia, :id_chatbot)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("Nombre", Usuario.getNombre())
                        .addParameter("Apellido", Usuario.getApellido())
                        .addParameter("edad", Usuario.getEdad())
                        .addParameter("Correo", Usuario.getCorreo())
                        .addParameter("Contrasenia", Usuario.getContrasenia())
                        .addParameter("loginToken", 0)
                        .addParameter("id_chatbot", Usuario.getId_chatbot())
                        .executeUpdate().getKey();
                Usuario.setId(insertedId);
                return Usuario;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Usuario Login2(String corr, String contra) {
        try(Connection conn = sql2o.open()){
            Usuario v1 = conn.createQuery("SELECT * FROM Usuario WHERE Correo = :corr AND Contrasenia = :contra")
            .addParameter("corr",corr)
            .addParameter("contra",contra)
            .executeAndFetchFirst(Usuario.class);
            if (v1 != null){
                return v1;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteUsuario(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Usuario WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario getUsuario(long id){
		String sql = "SELECT *  from Usuario where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Usuario.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateUsuario(Usuario nuevoUsuario){
        String updateSql = "update Usuario set Nombre = : Nombre, Apellido = : Apellido, edad = : edad, Correo = : Correo, Contrasenia = : Contrasenia, loginToken = :loginToken, id_chatbot = : id_chatbot where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("id", nuevoUsuario.getId())
                .addParameter("Apellido", nuevoUsuario.getApellido())
                .addParameter("Nombre",nuevoUsuario.getNombre())
                .addParameter("edad", nuevoUsuario.getEdad())
                .addParameter("Correo", nuevoUsuario.getCorreo())
                .addParameter("Contrasenia", nuevoUsuario.getContrasenia())
                .addParameter("loginToken", nuevoUsuario.getLoginToken())
                .addParameter("id_chatbot", nuevoUsuario.getId_chatbot())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario getUserByToken(String token){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario WHERE loginToken = :loginToken")
                    .addParameter("loginToken", token)
                    .executeAndFetchFirst(Usuario.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario logIn(Usuario user) {
        System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
        try(Connection conn = sql2o.open()){
            System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
            List<Usuario> findUsers = conn.createQuery("select * from Usuario where Correo=:Correo and Contrasenia=:Contrasenia")
                .addParameter("Correo", user.getCorreo())
                .addParameter("Contrasenia", user.getContrasenia())
                .executeAndFetch(Usuario.class);
            if(findUsers.size() == 1){
                System.out.println("Usuario ingresado con exito");
                user.setLoginToken(1);
                updateUsuario(user);
                return user;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }   
    @Override
    public String logOut(Usuario user){
        try(Connection conn = sql2o.open()){
            List<Usuario> findUsers = conn.createQuery("select * from Usuario where id=:id")
                    .addParameter("id", user.getId())
                    .executeAndFetch(Usuario.class);
            if(findUsers.size() == 1){
                try(Connection con = sql2o.open()){
                    user.setLoginToken(0);
                    updateUsuario(user);
                    return "LogOut Successfully";
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return  "LogOut Fail";
                }
            }else{
                return "LogOut Fail";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return " Deslogeado Fail";
        }
    }
}
