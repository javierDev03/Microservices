package UsersService.UsersService.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final List<UserDTO> users = List.of(
            new UserDTO(1L, "Alice"),
            new UserDTO(2L, "Bob"),
            new UserDTO(3L, "Charlie")
    );

    // DTO 
    public record UserDTO(Long id, String name) {}

    // Method to get all users
    public List<UserDTO> getAllUsers() {
        return users;
    }

    // MMethod to find user by id
    public UserDTO getUserById(Long id) {
        return users.stream()
                .filter(u -> u.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
