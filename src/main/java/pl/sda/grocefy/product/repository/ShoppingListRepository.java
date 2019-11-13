package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {
    ShoppingListEntity findByHash(String hash);
    List<ShoppingListEntity> findAllByOwnerId(Long id);
}
