package space.vendas.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vendas.sistema.domain.Evento;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Evento, Long> {

  //findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
  //List<Evento> findAllByDateStartLessThanEqualAndDateEndGreaterThanEqualOrDateEndLessThanEqualAndDateEndGreaterThanEqual(LocalDateTime dateStart, LocalDateTime dateEnd, LocalDateTime dateStart2, LocalDateTime dateEnd2);

  List<Evento> findAllByDateStartLessThanEqualAndDateEndGreaterThanEqual(LocalDateTime dateEnd, LocalDateTime dateStart);
  List<Evento> findAllByDateEndLessThanEqualAndDateEndGreaterThanEqual(LocalDateTime dateEnd, LocalDateTime dateStart);

}
