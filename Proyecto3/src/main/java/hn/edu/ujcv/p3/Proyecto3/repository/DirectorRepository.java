package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> findBynombreDirector (String nombreDirector);
}
