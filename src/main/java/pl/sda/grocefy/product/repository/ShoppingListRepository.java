package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
import pl.sda.grocefy.product.entity.UserEntity;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {
    ShoppingListEntity findByHash(String hash);
    List<ShoppingListEntity> findAllByUser(UserEntity user);
    List<ShoppingListEntity> findAllByUserAndIsPublic(UserEntity user, boolean isPublic);


}
