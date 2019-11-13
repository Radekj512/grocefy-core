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
public class registerValidator implements Validator {

    private final UserService userService;

    public registerValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;
        if(userService.findUser(userDTO.getUsername())!=null)
        {
            errors.rejectValue("username","register.validator.username.taken");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","register.validator.email.taken");
        //|| userService.findUser(userDTO.getEmail())!=null)
//        if(userDTO.getEmail()==null
//        )
//        {
//            errors.rejectValue("email","register.validator.email.taken");
//        }
        if(userDTO.getPassword()==null
        )//|| userDTO.getPassword().length()<8)
        {

            errors.rejectValue("password","register.validator.password.short");
        }

    }
}
