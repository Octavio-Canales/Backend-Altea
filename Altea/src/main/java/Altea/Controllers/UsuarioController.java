package Altea.Controllers;

import Altea.Models.Usuario;
import Altea.Repositories.UsuarioRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.getAllUsuario();
    }

    @GetMapping("/usuarios/{Correo}/{Contrasenia}")
    public Usuario Login2(@PathVariable (value = "Correo") String corr, @PathVariable (value = "Contrasenia") String contra){
        return usuarioRepository.Login2(corr, contra);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable(value="id") Long id){
        return usuarioRepository.getUsuario(id);
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario2(@RequestBody Usuario usuario){
        return usuarioRepository.createUsuario2(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable (value = "id") Long id){
        usuarioRepository.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }
}
