package hn.edu.ujcv.p3.Proyecto3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventaboleto")
public class VentaBoleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombrePelicula;
    private int    cantidadBoletos;
    private int    precioBoleto;
    private Date fecha;
}
