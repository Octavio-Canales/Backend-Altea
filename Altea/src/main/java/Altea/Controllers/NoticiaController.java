package Altea.Controllers;

import Altea.Models.Noticia;
import Altea.Repositories.NoticiaRepository;

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
public class NoticiaController {
    @Autowired
    NoticiaRepository noticiaRepository;

    @GetMapping("/noticias")
    public List<Noticia> getAllNoticia(){
        return noticiaRepository.getAllNoticia();
    }

    @GetMapping("/noticias/{id}")
    public Noticia getNoticia(@PathVariable(value="id") Long id){
        return noticiaRepository.getNoticia(id);
    }

    @PostMapping("/noticias")
    public Noticia createNoticia(@RequestBody Noticia noticia){
        return noticiaRepository.createNoticia(noticia);
    }

    @DeleteMapping("/noticia/{id}")
    public ResponseEntity<Noticia> deleteNoticia(@PathVariable (value = "id") Long id){
        noticiaRepository.deleteNoticia(id);
        return ResponseEntity.ok().build();
    }
}
