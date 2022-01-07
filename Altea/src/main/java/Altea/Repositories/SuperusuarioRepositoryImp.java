package Altea.Repositories;

import Altea.Models.Superusuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class SuperusuarioRepositoryImp implements SuperusuarioRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countSuperusuario() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Superusuario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Superusuario> getAllSuperusuario() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Superusuario").executeAndFetch(Superusuario.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Superusuario createSuperusuario(Superusuario SuperUsuario) {
        try(Connection conn = sql2o.open()){
            Superusuario v1 = conn.createQuery("select * from SuperUsuario where Correo=:Correo").addParameter("Correo",SuperUsuario.getCorreo()).executeAndFetchFirst(Superusuario.class);
            if (v1 == null){
                int insertedId = countSuperusuario()+1;
                conn.createQuery("insert into SuperUsuario (ID, Nombre, Apellido, Correo, Contrasenia, loginToken)"+
                        " values (:ID, :Nombre, :Apellido, :Correo, :Contrasenia)") 
                        .addParameter("ID",  insertedId)                
                        .addParameter("Nombre", SuperUsuario.getNombre())
                        .addParameter("Apellido", SuperUsuario.getApellido())
                        .addParameter("correo", SuperUsuario.getCorreo())
                        .addParameter("Contrasenia", SuperUsuario.getContrasenia())
                        .addParameter("loginToken", 0)
                        .executeUpdate().getKey();
                SuperUsuario.setId(insertedId);
                return SuperUsuario;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Superusuario Login2(String corr, String contra) {
        try(Connection conn = sql2o.open()){
            Superusuario v1 = conn.createQuery("SELECT * FROM Superusuario WHERE Correo = :corr AND Contrasenia = :contra")
            .addParameter("corr",corr)
            .addParameter("contra",contra)
            .executeAndFetchFirst(Superusuario.class);
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
    public boolean deleteSuperusuario(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Superusuario WHERE ID = :ID")
            .addParameter("ID", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Superusuario getSuperusuario(long id){
		String sql = "SELECT * from Superusuario where ID=:ID";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("ID", id)
				.executeAndFetchFirst(Superusuario.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateSuperusuario(Superusuario nuevoSuperusuario){
        String updateSql = "update Superusuario set Nombre = : Nombre, Apellido = : Apellido, Correo = : Correo, Contrasenia = : Contrasenia, loginToken = :loginToken where ID = :ID";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Apellido", nuevoSuperusuario.getApellido())
                .addParameter("Nombre",nuevoSuperusuario.getNombre())
                .addParameter("ID", nuevoSuperusuario.getId())
                .addParameter("Correo", nuevoSuperusuario.getCorreo())
                .addParameter("Contrasenia", nuevoSuperusuario.getContrasenia())
                .addParameter("loginToken", nuevoSuperusuario.getLoginToken())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Superusuario getUserByToken(String token){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Superusuario WHERE loginToken = :loginToken")
                    .addParameter("loginToken", token)
                    .executeAndFetchFirst(Superusuario.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Superusuario logIn(Superusuario user) {
        System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
        try(Connection conn = sql2o.open()){
            System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
            List<Superusuario> findUsers = conn.createQuery("select * from Superusuario where Correo=:Correo and Contrasenia=:Contrasenia")
                .addParameter("Correo", user.getCorreo())
                .addParameter("Contrasenia", user.getContrasenia())
                .executeAndFetch(Superusuario.class);
            if(findUsers.size() == 1){
                System.out.println("Superusuario ingresado con exito");
                user.setLoginToken(1);
                updateSuperusuario(user);
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
    public String logOut(Superusuario user){
        try(Connection conn = sql2o.open()){
            List<Superusuario> findUsers = conn.createQuery("select * from Superusuario where ID=:ID")
                    .addParameter("ID", user.getId())
                    .executeAndFetch(Superusuario.class);
            if(findUsers.size() == 1){
                try(Connection con = sql2o.open()){
                    user.setLoginToken(0);
                    updateSuperusuario(user);
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