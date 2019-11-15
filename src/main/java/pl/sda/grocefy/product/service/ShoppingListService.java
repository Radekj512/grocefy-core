package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.exception.ListNotFoundException;
import pl.sda.grocefy.product.exception.WebApplicationException;

import java.util.List;

public interface ShoppingListService {
    ShoppingListDTO findListByHash(String hash) throws ListNotFoundException;
    List<ShoppingListDTO> getAll();
    void addList(ShoppingListDTO shoppingListDTO);
    void deleteList(String hash);
    List<ShoppingListDTO> findAllByUserId(Long id);
    Long findUserIdByListHash(String hash);
    List<ShoppingListDTO>findAllPublicByUserId(Long id);
}
