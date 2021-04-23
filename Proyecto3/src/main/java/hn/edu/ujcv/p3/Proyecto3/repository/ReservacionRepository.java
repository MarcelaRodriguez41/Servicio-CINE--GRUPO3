package hn.edu.ujcv.p3.Proyecto3.repository;


import hn.edu.ujcv.p3.Proyecto3.entity.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
    Optional<Reservacion> findBynombreCliente (String nombreCliente);
}
