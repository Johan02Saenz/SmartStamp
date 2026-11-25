package com.smartStamp.etiquetas.domain.repository;

import java.util.Optional;

import com.smartStamp.etiquetas.domain.model.Codigo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;

@ApplicationScoped
public class CodigoRepository implements PanacheRepository<Codigo> {

    public Optional<Codigo> findByReference(String referencia) {
        return Optional.ofNullable(find("codigoReferencia", referencia).firstResult());
    }

    public Boolean existByCode(String code) {
        return count("codigo", code) > 0;
    }

    public Optional<Codigo> findByCodeForUpdate(String code){
        return find("code",code).withLock(LockModeType.PESSIMISTIC_WRITE).firstResultOptional();
    }

}
