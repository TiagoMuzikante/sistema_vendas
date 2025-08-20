package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
