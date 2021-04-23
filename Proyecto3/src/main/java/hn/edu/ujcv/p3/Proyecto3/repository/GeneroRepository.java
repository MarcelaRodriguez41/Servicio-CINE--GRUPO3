package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findBycategoria (String categoria);
}
