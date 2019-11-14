package pl.sda.grocefy.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.sda.grocefy.product.dto.LoginInfoDTO;
import pl.sda.grocefy.product.dto.RegisterInfoDTO;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.service.UserService;
import pl.sda.grocefy.product.validator.RegisterValidator;

import javax.validation.Valid;


@Controller
public class RegisterController implements WebMvcConfigurer {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("add-new")
    public ModelAndView getRegisterPage(WebRequest request, ModelAndView mav) {
        mav.setViewName("register");
        mav.addObject("newUser", new UserDTO());
        return mav;
    }

    @PostMapping("add-new")
    ModelAndView registerUser(@ModelAttribute("newUser") @Valid UserDTO registerInfo, BindingResult bindingResult, Errors errors){
        RegisterValidator validator = new RegisterValidator(userService);
        ModelAndView mav = new ModelAndView("register");
        validator.validate(registerInfo, errors);
        if (errors.hasErrors()){
            mav.addObject(errors);
        }else{
            userService.addUser(registerInfo);
            mav.addObject("success", "success");
            mav.addObject("loginInfo", new LoginInfoDTO()) ;
            mav.setViewName("login");
        }
        return mav;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("register");
    }


}


