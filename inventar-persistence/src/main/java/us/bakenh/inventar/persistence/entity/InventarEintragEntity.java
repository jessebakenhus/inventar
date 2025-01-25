package us.bakenh.inventar.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventar_eintrag")
public class InventarEintragEntity {

    @Id
    @Column(name = "inventar_eintrag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bezeichnung;

    private Integer anzahl;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "inventar_id", nullable = false)
    private InventarEntity inventar;
}
