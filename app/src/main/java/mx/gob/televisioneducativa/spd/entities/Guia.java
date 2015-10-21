package mx.gob.televisioneducativa.spd.entities;

/**
 * Created by JITOLEDO on 20/10/2015.
 */
public class Guia {
    private String guiaEstudio ;
    private String pdfGuia ;
    private String pdfPerfil ;

    public Guia(String guiaEstudio, String pdfGuia, String pdfPerfil){
        this.guiaEstudio = guiaEstudio;
        this.pdfGuia = pdfGuia;
        this.pdfPerfil = pdfPerfil;
    }

    public String getGuiaEstudio() {
        return guiaEstudio;
    }

    public void setGuiaEstudio(String guiaEstudio) {
        this.guiaEstudio = guiaEstudio;
    }

    public String getPdfGuia() {
        return pdfGuia;
    }

    public void setPdfGuia(String pdfGuia) {
        this.pdfGuia = pdfGuia;
    }

    public String getPdfPerfil() {
        return pdfPerfil;
    }

    public void setPdfPerfil(String pdfPerfil) {
        this.pdfPerfil = pdfPerfil;
    }
}
