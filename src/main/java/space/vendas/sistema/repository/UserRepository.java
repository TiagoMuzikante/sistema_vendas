package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.enums.UserType;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByType(UserType type);

}
