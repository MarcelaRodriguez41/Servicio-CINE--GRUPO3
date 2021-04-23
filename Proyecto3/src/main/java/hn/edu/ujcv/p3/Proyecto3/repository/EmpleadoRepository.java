package hn.edu.ujcv.p3.Proyecto3.repository;


import hn.edu.ujcv.p3.Proyecto3.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findBynombreEmpleado (String nombreEmpleado);
}
