package us.bakenh.inventar.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class InventarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "inventarEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventarEintragEntity> inventarEintragEntities;
}
