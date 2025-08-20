package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
