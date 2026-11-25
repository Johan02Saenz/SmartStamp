package com.smartStamp.etiquetas.application;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

import com.smartStamp.etiquetas.domain.model.Codigo;
import com.smartStamp.etiquetas.domain.repository.CodigoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GenerarCodigo {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LONGITUD_CODIGO = 8;
    private static final SecureRandom R = new SecureRandom();

    @Inject
    private CodigoRepository codigoRepository;

    private String generarCodigo() {
        StringBuilder sb = new StringBuilder(LONGITUD_CODIGO);
        for (int i = 0; i < LONGITUD_CODIGO; i++) {
            int index = R.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(index));
        }

        return sb.toString();
    }

    @Transactional
    public Codigo crearCodigo(String referenciaOrden) {
        Optional<Codigo> cdgExist = codigoRepository.findByReference(referenciaOrden);
        if (cdgExist.isPresent()) {
            return cdgExist.get();
        }
        String code;
        do {
            code = generarCodigo();
        } while (codigoRepository.existByCode(code));
        Codigo cdg = new Codigo();
        cdg.setCodigo(code);
        cdg.setCodigoReferencia(referenciaOrden);
        cdg.setEstado("pendiente");
        cdg.setFechaCreacion(LocalDateTime.now());
        cdg.setFechaExpiracion(LocalDateTime.now().plusHours(24));
        codigoRepository.persist(cdg);
        return cdg;
    }

}
