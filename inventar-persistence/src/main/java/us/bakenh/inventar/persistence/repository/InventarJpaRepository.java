package us.bakenh.inventar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.bakenh.inventar.persistence.entity.InventarEntity;

public interface InventarJpaRepository extends JpaRepository<InventarEntity, Integer> {
}
