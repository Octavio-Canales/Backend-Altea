package Altea.Controllers;

import java.util.List;

import Altea.Models.Chatbot;
import Altea.Repositories.ChatbotRepository;

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
public class ChatbotController {
    @Autowired
    ChatbotRepository chatbotRepository;

    @GetMapping("/chatbots")
    public List<Chatbot> getAllChatbots(){
        return chatbotRepository.getAllChatbot();
    }

    @GetMapping("/chatbots/{id}")
    public Chatbot getChatbot(@PathVariable(value="id") Long id){
        return chatbotRepository.getChatbot(id);
    }

    @PostMapping("/chatbots")
    public Chatbot createChatbot(@RequestBody Chatbot chatbot){
        return chatbotRepository.createChatbot(chatbot);
    }

    @DeleteMapping("/chatbot/{id}")
    public ResponseEntity<Chatbot> deleteChatbot(@PathVariable (value = "id") Long id){
        chatbotRepository.deleteChatbot(id);
        return ResponseEntity.ok().build();
    }
}
