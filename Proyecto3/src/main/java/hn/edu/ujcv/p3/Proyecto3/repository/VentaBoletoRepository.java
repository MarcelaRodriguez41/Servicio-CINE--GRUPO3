package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaBoleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentaBoletoRepository extends JpaRepository<VentaBoleto, Long> {
    Optional<VentaBoleto> findBynombreCliente (String nombreCliente);
}
