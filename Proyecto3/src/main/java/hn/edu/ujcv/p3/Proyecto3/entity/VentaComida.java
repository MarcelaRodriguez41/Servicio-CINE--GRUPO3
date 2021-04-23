package hn.edu.ujcv.p3.Proyecto3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventacomida")
public class VentaComida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombreProducto;
    private int    precioProducto;
    private int    cantidadProducto;
}
