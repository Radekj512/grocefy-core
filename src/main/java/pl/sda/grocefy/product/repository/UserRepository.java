package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity>  findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
