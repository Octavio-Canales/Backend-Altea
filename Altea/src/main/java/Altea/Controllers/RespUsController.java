package Altea.Controllers;

import Altea.Models.RespUs;
import Altea.Repositories.RespUsRepository;

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
public class RespUsController {
    @Autowired
    RespUsRepository respUsRepository;

    @GetMapping("/respUss")
    public List<RespUs> getAllRespUs(){
        return respUsRepository.getAllRespUs();
    }

    @GetMapping("/respUss/{id}")
    public RespUs getRespUs(@PathVariable(value="id") Long id){
        return respUsRepository.getRespUs(id);
    }

    @PostMapping("/respUss")
    public RespUs createRespUs(@RequestBody RespUs respUs){
        return respUsRepository.createRespUs(respUs);
    }

    @DeleteMapping("/respUs/{id}")
    public ResponseEntity<RespUs> deleteRespUs(@PathVariable (value = "id") Long id){
        respUsRepository.deleteRespUs(id);
        return ResponseEntity.ok().build();
    }
}