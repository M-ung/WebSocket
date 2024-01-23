package websocket.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import websocket.websocket.entity.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAllByOrderByTimestampAsc();
}