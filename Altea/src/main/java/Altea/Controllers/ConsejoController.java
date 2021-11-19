package Altea.Controllers;

import Altea.Models.Consejo;
import Altea.Repositories.ConsejoRepository;

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
public class ConsejoController {
    @Autowired
    ConsejoRepository consejoRepository;

    @GetMapping("/consejos")
    public List<Consejo> getAllConsejo(){
        return consejoRepository.getAllConsejo();
    }

    @GetMapping("/consejos/{id}")
    public Consejo getConsejo(@PathVariable(value="id") Long id){
        return consejoRepository.getConsejo(id);
    }

    @PostMapping("/consejos")
    public Consejo createConsejo(@RequestBody Consejo consejo){
        return consejoRepository.createConsejo(consejo);
    }

    @DeleteMapping("/consejo/{id}")
    public ResponseEntity<Consejo> deleteConsejo(@PathVariable (value = "id") Long id){
        consejoRepository.deleteConsejo(id);
        return ResponseEntity.ok().build();
    }
}
