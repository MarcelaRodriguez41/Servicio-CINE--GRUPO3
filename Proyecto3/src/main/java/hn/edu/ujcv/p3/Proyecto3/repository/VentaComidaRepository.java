package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaComida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentaComidaRepository extends JpaRepository<VentaComida, Long> {
    Optional<VentaComida> findBynombreCliente (String nombreCliente);
}
