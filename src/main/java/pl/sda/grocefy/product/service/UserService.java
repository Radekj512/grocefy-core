package pl.sda.grocefy.product.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.sda.grocefy.product.dto.UserDTO;

public interface UserService {

    UserDTO findUser(String username);
    void addUser(UserDTO newUser);
   // UserDTO findUserByEmail(String email);
    Long getUserId();
}
