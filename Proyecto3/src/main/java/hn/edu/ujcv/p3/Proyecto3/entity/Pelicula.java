package hn.edu.ujcv.p3.Proyecto3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombrePelicula;
    private String sinopsis;
    private String genero;
    private String nacionalidad;
    private String duracion;
    private String director;

}
