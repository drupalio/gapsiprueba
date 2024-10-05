package mx.com.grupoasesores.challenge.repository;

import java.util.Optional;

import mx.com.grupoasesores.challenge.repository.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String username);
}