package space.vendas.sistema.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import jdk.jfr.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.Evento;
import space.vendas.sistema.dto.event.EventDTO;
import space.vendas.sistema.repository.EventRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

  private final EventRepository eventRepository;

  public Evento save(EventDTO dto){
    return eventRepository.save(toEntity(dto));
  }

  public Evento findById(Long id){
    return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
  }

  public List<Evento> findAll(){
    return eventRepository.findAll();
  }

  public List<EventDTO> findAllBetweenDates(LocalDate startDate, LocalDate endDate){

    List<Evento> events = new ArrayList<>();
        events.addAll(eventRepository.findAllByDateStartLessThanEqualAndDateEndGreaterThanEqual(endDate.atTime(LocalTime.MAX), startDate.atStartOfDay()));
        events.addAll(eventRepository.findAllByDateEndLessThanEqualAndDateEndGreaterThanEqual(endDate.atTime(LocalTime.MAX), startDate.atStartOfDay()));
    return events.stream().distinct().map(this::toDto).toList();

  }

  private Evento toEntity(EventDTO dto){
    Evento event = new Evento();
    BeanUtils.copyProperties(dto, event);
    return event;
  }

  private EventDTO toDto(Evento evento){
    EventDTO dto = new EventDTO();
    BeanUtils.copyProperties(evento, dto);
    return dto;
  }

  public Evento update(Long id, EventDTO dto){
    Evento evento = toEntity(dto);
    evento.setId(id);
    return eventRepository.save(evento);
  }

  public void destroy(Long id){
    eventRepository.deleteById(id);
  }

}
