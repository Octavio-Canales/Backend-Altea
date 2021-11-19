package Altea.Controllers;
import Altea.Models.Patologia;
import Altea.Repositories.PatologiaRepository;

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
public class PatologiaController {
    @Autowired
    PatologiaRepository patologiaRepository;

    @GetMapping("/patologias")
    public List<Patologia> getAllPatologias(){
        return patologiaRepository.getAllPatologia();
    }

    @GetMapping("/patologias/{id}")
    public Patologia getPatologia(@PathVariable(value="id") Long id){
        return patologiaRepository.getPatologia(id);
    }

    @PostMapping("/patologias")
    public Patologia createPatologia(@RequestBody Patologia patologia){
        return patologiaRepository.createPatologia(patologia);
    }

    @DeleteMapping("/patologia/{id}")
    public ResponseEntity<Patologia> deletePatologia(@PathVariable (value = "id") Long id){
        patologiaRepository.deletePatologia(id);
        return ResponseEntity.ok().build();
    }
}
