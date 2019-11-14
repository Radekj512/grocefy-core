package pl.sda.grocefy.product.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.sda.grocefy.product.dto.RegisterInfoDTO;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.service.UserService;

@Component
public class RegisterValidator implements Validator {

    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;
        long usernameCount = userService.getAll().stream().filter(user -> user.getUsername().equalsIgnoreCase(userDTO.getUsername())).count();
        long emailCount = userService.getAll().stream().filter(user -> user.getEmail().equalsIgnoreCase(userDTO.getEmail())).count();

        if (usernameCount > 0) {
            errors.rejectValue("username", "register.validator.username.taken");
        }
        if (emailCount > 0) {
            errors.rejectValue("email", "register.validator.email.taken");
        }

        if (userDTO.getPassword().length() < 8) {
            errors.rejectValue("password", "register.validator.password.short");
        }

    }
}
