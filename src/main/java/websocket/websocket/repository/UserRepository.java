package websocket.websocket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import websocket.websocket.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
