package hn.edu.ujcv.p3.Proyecto3.repository;


import hn.edu.ujcv.p3.Proyecto3.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    Optional<Pelicula> findBynombrePelicula (String nombrePelicula);

}
