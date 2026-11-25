package com.smartStamp.etiquetas.application;

import java.util.Optional;

import com.smartStamp.etiquetas.domain.model.Codigo;
import com.smartStamp.etiquetas.domain.repository.CodigoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CodigoService {
    @Inject
    private CodigoRepository repo;

    public void guardar(Codigo codigo) {
        repo.persist(codigo);
    }

    public Optional<Codigo> find(String referencia) {
        return repo.findByReference(referencia);
    }
}
