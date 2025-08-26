package UsersService.UsersService;

import org.springframework.web.bind.annotation.*;

import UsersService.UsersService.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to get all users
    @GetMapping
    public List<UserService.UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}")
    public UserService.UserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
