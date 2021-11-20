package Altea.Controllers;

import Altea.Models.Estadistica;
import Altea.Repositories.EstadisticaRepository;

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
public class EstadisticaController {
    @Autowired
    EstadisticaRepository estadisticaRepository;

    @GetMapping("/estadisticas")
    public List<Estadistica> getAllEstadisticas(){
        return estadisticaRepository.getAllEstadistica();
    }

    @GetMapping("/estadisticas/{id}")
    public Estadistica getEstadistica(@PathVariable(value="id") Long id){
        return estadisticaRepository.getEstadistica(id);
    }

    @PostMapping("/estadisticas")
    public Estadistica createEstadistica(@RequestBody Estadistica estadistica){
        return estadisticaRepository.createEstadistica(estadistica);
    }

    @DeleteMapping("/estadistica/{id}")
    public ResponseEntity<Estadistica> deleteEstadistica(@PathVariable (value = "id") Long id){
        estadisticaRepository.deleteEstadistica(id);
        return ResponseEntity.ok().build();
    }
}
