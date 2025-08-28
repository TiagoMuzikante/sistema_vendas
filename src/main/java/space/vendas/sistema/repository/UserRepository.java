package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
