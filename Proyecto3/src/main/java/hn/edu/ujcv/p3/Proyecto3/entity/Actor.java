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
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long    id;
    private String nombreActor;
    private String alias;
    private String generosInterpretados;
    private String nacionalidad;
    private String sexo;
    private Date   fechaNacimiento;
    private int    cantidadPeliculasGrabadas;


}
