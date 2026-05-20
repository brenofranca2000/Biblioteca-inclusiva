package org.serratec.biblioteca_inclusiva.dto;

public class PerfilAcessibilidadeResponseDTO {

    private Long id;

    private String tipoDeficiencia;

    private Boolean necessitaAudiobook;

    private Boolean necessitaFonteAmpliada;

    public Long getId() {
        return id;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public Boolean getNecessitaAudiobook() {
        return necessitaAudiobook;
    }

    public Boolean getNecessitaFonteAmpliada() {
        return necessitaFonteAmpliada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public void setNecessitaAudiobook(Boolean necessitaAudiobook) {
        this.necessitaAudiobook = necessitaAudiobook;
    }

    public void setNecessitaFonteAmpliada(Boolean necessitaFonteAmpliada) {
        this.necessitaFonteAmpliada = necessitaFonteAmpliada;
    }
}