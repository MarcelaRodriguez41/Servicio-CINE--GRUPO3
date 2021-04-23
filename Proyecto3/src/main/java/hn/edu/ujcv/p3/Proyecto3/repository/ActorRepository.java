package hn.edu.ujcv.p3.Proyecto3.repository;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ActorRepository extends JpaRepository<Actor, Long> {

        Optional<Actor> findBynombreActor (String nombreActor);

    }