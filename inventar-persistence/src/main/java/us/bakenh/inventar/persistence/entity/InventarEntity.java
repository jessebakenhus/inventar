package us.bakenh.inventar.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "inventar")
public class InventarEntity {

    @Id
    @Column(name = "inventar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventarEintragEntity> eintraege;
}
