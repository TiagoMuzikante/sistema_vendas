package space.vendas.sistema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.Inscription;
import space.vendas.sistema.dto.inscription.InscriptionPostDTO;
import space.vendas.sistema.dto.inscription.InscriptionSimple;
import space.vendas.sistema.repository.EventRepository;
import space.vendas.sistema.repository.InscriptionRepository;
import space.vendas.sistema.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InscriptionService {

  private final InscriptionRepository inscriptionRepository;
  private final EventRepository eventRepository;
  private final UserRepository userRepository;

  public InscriptionSimple save(InscriptionPostDTO dto){
    Inscription inscription = Inscription.builder()
        .event(eventRepository.findById(dto.getEvent_id()).orElseThrow(() -> new RuntimeException("Evento não encontrado")))
        .paymentStatus(dto.getPaymentStatus())
        .user(userRepository.findById(dto.getUser_id()).orElseThrow(() -> new RuntimeException("Usuario não encontrado")))
        .created_at(dto.getCreated_at())
        .updated_at(dto.getUpdated_at())
        .build();
    Inscription saved = inscriptionRepository.save(inscription);
    return new InscriptionSimple(saved.getId(), saved.getEvent().getName(), saved.getUser().getName(), Date.from(saved.getCreated_at().atZone(ZoneId.systemDefault()).toInstant()));
  }

  public InscriptionSimple findById(Long id){
    Inscription saved = inscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
    return new InscriptionSimple(saved.getId(), saved.getEvent().getName(), saved.getUser().getName(), Date.from(saved.getCreated_at().atZone(ZoneId.systemDefault()).toInstant()));
  }

  public List<InscriptionSimple> findAll(){
    return inscriptionRepository.findAll().stream()
        .map(aux -> new InscriptionSimple(aux.getId(), aux.getEvent().getName(), aux.getUser().getName(), Date.from(aux.getCreated_at().atZone(ZoneId.systemDefault()).toInstant())))
        .collect(Collectors.toList());
  }

  public InscriptionSimple update(Long id, InscriptionPostDTO dto){
    Inscription inscription = Inscription.builder()
        .id(id)
        .event(eventRepository.findById(dto.getEvent_id()).orElseThrow(() -> new RuntimeException("Evento não encontrado")))
        .user(userRepository.findById(dto.getUser_id()).orElseThrow(() -> new RuntimeException("Usuario não encontrado")))
        .paymentStatus(dto.getPaymentStatus())
        .updated_at(dto.getUpdated_at())
        .created_at(inscriptionRepository.findById(id).get().getCreated_at())
        .build();
    Inscription saved = inscriptionRepository.save(inscription);
    return new InscriptionSimple(saved.getId(), saved.getEvent().getName(), saved.getUser().getName(), Date.from(saved.getCreated_at().atZone(ZoneId.systemDefault()).toInstant()));
  }

  public void destroy(Long id){
    inscriptionRepository.deleteById(id);
  }

}
