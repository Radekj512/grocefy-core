package pl.sda.grocefy.product.dto;

import lombok.*;
import pl.sda.grocefy.product.entity.Unit;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long id;
    private String product;
    private String hash;
    private Double count;
    private Unit unit;
}
