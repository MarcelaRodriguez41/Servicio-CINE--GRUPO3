package hn.edu.ujcv.p3.Proyecto3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String nombreSala;
    private int    cantidadFilas;
    private int    cantidadColumnas;
    private int    cantidadAsientosPreferencial;
    private String estadoDisponibilidad;
}
