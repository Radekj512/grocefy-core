package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.LoginInfoDTO;
import pl.sda.grocefy.product.dto.UserDTO;

@Controller
@RequestMapping("/login")
public class LoginController {


        @RequestMapping
        public ModelAndView getLogin(){
            ModelAndView mnv = new ModelAndView("login");
            mnv.addObject("loginInfo", new LoginInfoDTO()) ;
            return mnv;
        }



}


