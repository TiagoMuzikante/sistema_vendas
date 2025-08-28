package space.vendas.sistema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.Evento;
import space.vendas.sistema.dto.event.EventPostDTO;
import space.vendas.sistema.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

  private final EventRepository eventRepository;

  public Evento save(EventPostDTO dto){
    Evento event = Evento.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .type(dto.getType())
        .address(dto.getAddress())
        .date_start(dto.getDate_start())
        .date_end(dto.getDate_end())
        .link_event(dto.getLink_event())
        .link_image(dto.getLink_image())
        .build();
    return eventRepository.save(event);
  }

  public Evento findById(Long id){
    return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
  }

  public List<Evento> findAll(){
    return eventRepository.findAll();
  }

  public Evento update(Long id, EventPostDTO dto){
    Evento event = Evento.builder()
        .id(id)
        .name(dto.getName())
        .description(dto.getDescription())
        .type(dto.getType())
        .address(dto.getAddress())
        .date_start(dto.getDate_start())
        .date_end(dto.getDate_end())
        .link_event(dto.getLink_event())
        .link_image(dto.getLink_image())
        .updated_at(LocalDateTime.now())
        .build();
    return eventRepository.save(event);
  }

  public void destroy(Long id){
    eventRepository.deleteById(id);
  }

}
