package org.serratec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_acessibilidade")
public class perfilacessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDeficiencia;

    private Boolean necessitaAudiobook;

    private Boolean necessitaFonteAmpliada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public Boolean getNecessitaAudiobook() {
        return necessitaAudiobook;
    }

    public void setNecessitaAudiobook(Boolean necessitaAudiobook) {
        this.necessitaAudiobook = necessitaAudiobook;
    }

    public Boolean getNecessitaFonteAmpliada() {
        return necessitaFonteAmpliada;
    }

    public void setNecessitaFonteAmpliada(Boolean necessitaFonteAmpliada) {
        this.necessitaFonteAmpliada = necessitaFonteAmpliada;
    }
}