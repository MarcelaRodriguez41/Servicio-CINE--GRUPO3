package hn.edu.ujcv.p3.Proyecto3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private Time    horaInicio;
    private Time    horaFinal;
    private String  nombrePelicula;
    private Date    fecha;
}
