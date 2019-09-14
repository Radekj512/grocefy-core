package pl.sda.grocefy.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hash;

    @OneToOne
    private ProductEntity product;
    private int count;
    @Enumerated(EnumType.STRING)
    private Unit unit;

}
