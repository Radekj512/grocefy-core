package pl.sda.grocefy.product.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Setter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
}
