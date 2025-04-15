package org.example.tptresbackend.services;

import jakarta.transaction.Transactional;
import org.example.tptresbackend.entities.Instrumento;
import org.example.tptresbackend.repositories.InstrumentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrumentoService {

    private InstrumentoRepository instrumentoRepository;
    public InstrumentoService(InstrumentoRepository instrumentoRepository) {
        this.instrumentoRepository = instrumentoRepository;
    }

    private final String UPLOAD_DIR = "uploads/instrumentos/";

    @Transactional
    public List<Instrumento> findAll() throws Exception {
        try {
            return (List<Instrumento>) instrumentoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Instrumento findById(Long id) throws Exception {
        try {
            Optional<Instrumento> entityOptional = instrumentoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Instrumento save(Instrumento entity) throws Exception {
        try {
            return instrumentoRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    };

    @Transactional
    public Instrumento update(Long id, Instrumento entity) throws Exception {
        try {
            Optional<Instrumento> entityOptional = instrumentoRepository.findById(id);
            if (entityOptional.isPresent()) {
                Instrumento entityGen = entityOptional.get();
                BeanUtils.copyProperties(entity, entityGen, "id"); //copia el body del update en el objeto obtenido en el findById anterior, salvo el id pq ya lo trae
                return instrumentoRepository.save(entityGen);                         //Esto es necesario ya que usar un body sin un id en el metodo .save() crea un nuevo objeto
            } else {
                throw new Exception("Entidad con ID " + id + " no encontrada.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (instrumentoRepository.existsById(id)) {
                instrumentoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se encontro la entidad a borrar");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
