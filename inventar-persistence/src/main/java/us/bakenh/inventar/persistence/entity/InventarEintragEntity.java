package us.bakenh.inventar.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class InventarEintragEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bezeichnung;

    private Integer anzahl;

    @ManyToOne
    @JoinColumn(name = "inventar_id", nullable = false)
    private InventarEntity inventarEntity;
}
