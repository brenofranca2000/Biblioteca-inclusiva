package org.serratec.dto;

public class PerfilAcessibilidadeRequestDTO {

    private String tipoDeficiencia;

    private Boolean necessitaAudiobook;

    private Boolean necessitaFonteAmpliada;

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public Boolean getNecessitaAudiobook() {
        return necessitaAudiobook;
    }

    public Boolean getNecessitaFonteAmpliada() {
        return necessitaFonteAmpliada;
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