package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.exception.ListNotFoundException;
import pl.sda.grocefy.product.service.ShoppingListService;
import pl.sda.grocefy.product.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    private final UserService userService;
    private final ShoppingListService shoppingListService;

    public SearchController(UserService userService, ShoppingListService shoppingListService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
    }

    @RequestMapping(value = "/search", params = {"search"})
    ModelAndView searchResults(@RequestParam("search") String search) throws ListNotFoundException {
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("searchValue", search);

        Long userId = userService.getUserId(search);
        if (userId == 0L){
            ShoppingListDTO listByHash = shoppingListService.findListByHash(search);
            if (listByHash != null){
                mav.addObject("lists", listByHash);
                return mav;
            }
        }else {
            List<ShoppingListDTO> userLists = shoppingListService.findAllPublicByUserId(userId);
            mav.addObject("lists", userLists);
            return mav;
        }
        mav.addObject("notFound", "notFound");
        return mav;
    }
}
