package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Horario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.HorarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements IHorarioService{
    @Autowired
    private HorarioRepository repository;

    public Horario saveHorario (Horario horarios) throws BusinessException {
        try {
            return repository.save(horarios);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Horario> saveHorarios (List<Horario> horarios) throws BusinessException {
        try {
            return repository.saveAll(horarios);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Horario> getHorario() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public Horario getHorarioById (long id) throws BusinessException, NotFoundException {
        Optional<Horario> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Horario " + id);
        }
        return opt.get();
    }

    public Horario getHorariosByName (String nombrePelicula) throws BusinessException, NotFoundException {
        Optional<Horario> opt = null;
        try {
            opt = repository.findBynombrePelicula(nombrePelicula);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Horario " + nombrePelicula);
        }
        return opt.get();
    }

    public void deleteHorario (long id) throws BusinessException, NotFoundException {
        Optional<Horario> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Horario" + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Horario updateHorario (Horario horarios) throws BusinessException, NotFoundException {
        Optional<Horario> opt;
        try {
            opt = repository.findById(horarios.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Horario " + horarios.getId());
        } else {
            try {
                Horario existingHorario = new Horario();
                 existingHorario.setId(horarios.getId());
                 existingHorario.setHoraInicio(horarios.getHoraInicio());
                 existingHorario.setHoraFinal(horarios.getHoraFinal());
                 existingHorario.setNombrePelicula(horarios.getNombrePelicula());
                 existingHorario.setFecha(horarios.getFecha());

                return repository.save(existingHorario);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
