package pl.sda.grocefy.product.repository;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.ItemEntity;
import pl.sda.grocefy.product.entity.ProductEntity;
import pl.sda.grocefy.product.entity.ShoppingListEntity;

import java.util.List;


public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findAllByHash(String Hash);
    void deleteAllByHash(String hash);
}
