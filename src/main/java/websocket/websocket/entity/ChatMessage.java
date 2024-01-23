package websocket.websocket.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "message_table")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;

    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
