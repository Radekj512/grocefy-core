package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.ItemEntity;

import java.util.List;


public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findAllByHash(String Hash);
    void deleteAllByHash(String hash);
}
