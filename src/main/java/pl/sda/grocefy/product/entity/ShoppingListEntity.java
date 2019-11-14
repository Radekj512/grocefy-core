package pl.sda.grocefy.product.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "shopping_list")
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String hash;

    @ManyToOne
    private UserEntity user;
    }
