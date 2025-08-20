package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.Evento;

public interface EventRepository extends JpaRepository<Evento, Long> {
}
