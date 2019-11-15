package pl.sda.grocefy.product.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.sda.grocefy.product.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findUser(String username);
    UserDTO getLoggedUser();
    UserDTO findByID(Long id);
    void addUser(UserDTO newUser);
   // UserDTO findUserByEmail(String email);
    Long getUserId();
    List<UserDTO> getAll();
    Long getUserId(String username);
}
