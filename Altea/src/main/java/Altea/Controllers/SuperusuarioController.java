package Altea.Controllers;

import Altea.Models.Superusuario;
import Altea.Repositories.SuperusuarioRepository;

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
public class SuperusuarioController {
    @Autowired
    SuperusuarioRepository superusuarioRepository;

    @GetMapping("/superusuarios")
    public List<Superusuario> getAllSuperusuarios(){
        return superusuarioRepository.getAllSuperusuario();
    }

    @GetMapping("/superusuarios/{correo}")
    public Superusuario getSuperusuario(@PathVariable(value="correo") String correo){
        return superusuarioRepository.getSuperusuario(correo);
    }

    @PostMapping("/superusuarios")
    public Superusuario createSuperusuario(@RequestBody Superusuario superusuario){
        return superusuarioRepository.createSuperusuario(superusuario);
    }

    @GetMapping("/superusuarios/{Correo}/{Contrasenia}")
    public Superusuario Login2(@PathVariable (value = "Correo") String corr, @PathVariable (value = "Contrasenia") String contra){
        return superusuarioRepository.Login2(corr, contra);
    }

    @DeleteMapping("/superusuario/{id}")
    public ResponseEntity<Superusuario> deleteSuperusuario(@PathVariable (value = "id") Long id){
        superusuarioRepository.deleteSuperusuario(id);
        return ResponseEntity.ok().build();
    }
}
