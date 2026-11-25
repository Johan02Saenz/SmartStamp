package com.smartStamp.etiquetas.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "codigos")
public class Codigo {
    @Id
    @SequenceGenerator(name = "codigo_seq", sequenceName = "codigo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codigo_seq")
    @Column(name = "cdg_id")
    private Long id;
    @Column(name = "cdg_codigo")
    private String codigo;
    @Column(name = "cdg_codigoReferencia")
    private String codigoReferencia;
    @Column(name = "cdg_estado")
    private String estado;
    @Column(name = "cdg_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "cdg_expiracion")
    private LocalDateTime fechaExpiracion;

    public Codigo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Codigo [id=" + id + ", codigo=" + codigo + ", codigoReferencia=" + codigoReferencia + ", estado="
                + estado + ", fechaCreacion=" + fechaCreacion + ", fechaExpiracion=" + fechaExpiracion + "]";
    }

}
