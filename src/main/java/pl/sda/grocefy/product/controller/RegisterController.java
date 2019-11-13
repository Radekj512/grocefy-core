package pl.sda.grocefy.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.RegisterInfoDTO;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.service.UserService;

import javax.validation.Valid;
import javax.xml.ws.WebServiceException;


@Controller
@RequestMapping("/add-new")

public class RegisterController {

    private final UserService userService;
    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }




    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getRegisterPage(){
        ModelAndView mnv = new ModelAndView("register");
        mnv.addObject("registerInfo", new UserDTO()) ;
        return mnv;
    }

    @PostMapping
    ModelAndView registerUser(@Valid @ModelAttribute("registerInfo")  UserDTO registerInfo, BindingResult bindingResult) throws Exception {
        if(!bindingResult.hasErrors()){
            userService.addUser(registerInfo);}
             return new ModelAndView("redirect:/login");
     }
//        else {
//            return new ModelAndView("redirect:/add-new");
//        }

    }


