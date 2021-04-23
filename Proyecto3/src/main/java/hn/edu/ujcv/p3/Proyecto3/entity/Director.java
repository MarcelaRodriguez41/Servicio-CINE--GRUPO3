package hn.edu.ujcv.p3.Proyecto3.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "director")
public class Director {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long    id;
        private String  nombreDirector;
        private Date    fechaNacimiento;
        private int     cantidadPeliculasDirigidas;
        private String  nacionalidad;
        private String  generosDirigidos;
}

