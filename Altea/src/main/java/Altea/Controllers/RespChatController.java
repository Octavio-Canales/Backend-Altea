package Altea.Controllers;

import Altea.Models.RespChat;
import Altea.Repositories.RespChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class RespChatController {
    @Autowired
    RespChatRepository respChatRepository;

    @GetMapping("/respChats")
    public List<RespChat> getAllRespChat(){
        return respChatRepository.getAllRespChat();
    }

    @GetMapping("/respChats/{id}")
    public RespChat getRespChat(@PathVariable(value="id") Long id){
        return respChatRepository.getRespChat(id);
    }

    @PostMapping("/respChats")
    public RespChat createRespChat(@RequestBody RespChat respChat){
        return respChatRepository.createRespChat(respChat);
    }

    @DeleteMapping("/respChat/{id}")
    public ResponseEntity<RespChat> deleteRespChat(@PathVariable (value = "id") Long id){
        respChatRepository.deleteRespChat(id);
        return ResponseEntity.ok().build();
    }
}
