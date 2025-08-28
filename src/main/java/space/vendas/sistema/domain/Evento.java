package space.vendas.sistema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
@Builder
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EventEnum type;
  @Column(nullable = false)
  private String address;
  @Column(nullable = false)
  private Date date_start;
  @Column(nullable = false)
  private Date date_end;
  private String link_event;
  private String link_image;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;


  @OneToMany(mappedBy = "event")
  private List<Inscription> inscriptions;

}
