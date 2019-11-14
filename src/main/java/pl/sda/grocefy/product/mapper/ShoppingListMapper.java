package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
import pl.sda.grocefy.product.service.UserService;

@Component
public class ShoppingListMapper {

    public ShoppingListDTO mapToDTO(ShoppingListEntity shoppingListEntity){
        return ShoppingListDTO.builder()
                .name(shoppingListEntity.getName())
                .hash(shoppingListEntity.getHash())
                .build();
    }

    public ShoppingListEntity mapToEntity(ShoppingListDTO shoppingListDTO){
        return ShoppingListEntity.builder()
                .id(null)
                .name(shoppingListDTO.getName())
                .hash(shoppingListDTO.getHash())
                .build();
    }
}
