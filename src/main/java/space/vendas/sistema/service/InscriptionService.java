package space.vendas.sistema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.Inscription;
import space.vendas.sistema.dto.inscription.InscriptionDTO;
import space.vendas.sistema.repository.EventRepository;
import space.vendas.sistema.repository.InscriptionRepository;
import space.vendas.sistema.repository.UserRepository;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InscriptionService {

  private final InscriptionRepository inscriptionRepository;
  private final EventRepository eventRepository;
  private final UserRepository userRepository;

  public InscriptionDTO save(InscriptionDTO dto){
    return toDto(inscriptionRepository.save(toEntity(dto)));
  }

  public InscriptionDTO findById(Long id){
    return toDto(inscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Inscrição nao encontrada.")));
  }

  public List<InscriptionDTO> findAll(){
    return inscriptionRepository.findAll().stream()
        .map(this::toDto)
        .collect(Collectors.toList());
  }

  private Inscription toEntity(InscriptionDTO dto){
    Inscription inscription = new Inscription();
    BeanUtils.copyProperties(dto, inscription);
    return inscription;
  }

  private InscriptionDTO toDto(Inscription inscription){
    InscriptionDTO dto = new InscriptionDTO();
    BeanUtils.copyProperties(inscription, dto);
    return dto;
  }

  public InscriptionDTO update(Long id, InscriptionDTO dto){
    Inscription inscription = toEntity(dto);
    inscription.setId(id);
    return toDto(inscriptionRepository.save(inscription));
  }

  public void destroy(Long id){
    inscriptionRepository.deleteById(id);
  }

}
