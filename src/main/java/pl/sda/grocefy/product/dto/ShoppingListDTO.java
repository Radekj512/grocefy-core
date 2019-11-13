package pl.sda.grocefy.product.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListDTO {
    private String name;
    private String hash;
    private Long ownerId;
    private List<ItemDTO> items;

}
