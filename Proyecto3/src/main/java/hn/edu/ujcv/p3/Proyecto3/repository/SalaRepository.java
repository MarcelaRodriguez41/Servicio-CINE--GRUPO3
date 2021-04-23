package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findBynombreSala (String nombreSala);
}
