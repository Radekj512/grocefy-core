package pl.sda.grocefy.product.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoDTO {
    private String username;
    private String password;
}