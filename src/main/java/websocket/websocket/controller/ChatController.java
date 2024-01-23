package websocket.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import websocket.websocket.entity.ChatMessage;
import websocket.websocket.repository.ChatMessageRepository;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepository messageRepository;

    @MessageMapping("/chat/{chatRoomId}")
    @SendTo("/topic/messages/{chatRoomId}")
    public ChatMessage send(ChatMessage message) throws Exception {
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message); // 메시지를 데이터베이스에 저장
        return message;
    }

    @GetMapping("/chat/{chatRoomId}")
    public String chatPage(@PathVariable Long chatRoomId, Model model) {
        model.addAttribute("chatRoomId", chatRoomId);
        return "chat"; // chat.html 템플릿 반환
    }


}
