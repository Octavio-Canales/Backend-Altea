package Altea.Repositories;

import java.util.List;
import Altea.Models.Chatbot;

public interface ChatbotRepository {
    public int countChatbot();
    public List<Chatbot> getAllChatbot();
    public Chatbot createChatbot(Chatbot chatbot);
    public boolean deleteChatbot(long id);
    public Chatbot getChatbot(long id);
    public boolean updateChatbot(Chatbot nuevoChatbot);
}
