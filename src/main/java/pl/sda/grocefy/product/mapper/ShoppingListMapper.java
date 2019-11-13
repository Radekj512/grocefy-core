package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
@Component
public class ShoppingListMapper {


    public ShoppingListDTO mapToDTO(ShoppingListEntity shoppingListEntity){
        return ShoppingListDTO.builder()
                .name(shoppingListEntity.getName())
                .hash(shoppingListEntity.getHash())
                .ownerId(shoppingListEntity.getOwnerId()).build();
    }

    public ShoppingListEntity mapToEntity(ShoppingListDTO shoppingListDTO){
        return ShoppingListEntity.builder()
                .id(null)
                .name(shoppingListDTO.getName())
                .hash(shoppingListDTO.getHash())
                .ownerId(shoppingListDTO.getOwnerId()).build();
    }
}
