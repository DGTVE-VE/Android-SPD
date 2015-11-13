package mx.gob.televisioneducativa.spd.entities;

/**
 * Created by JITOLEDO on 09/11/2015.
 */
public class MaterialObject {
    private String guiaEstudio;
    private String dimension;
    private String bibliografia;
    private String urlNivel;

    public MaterialObject(String guiaEstudio, String dimension,String bibliografia, String urlNivel){
        this.setGuiaEstudio(guiaEstudio);
        this.setDimension(dimension);
        this.setBibliografia(bibliografia);
        this.setUrlNivel(urlNivel);
    }

    public String getGuiaEstudio() {
        return guiaEstudio;
    }

    public void setGuiaEstudio(String guiaEstudio) {
        this.guiaEstudio = guiaEstudio;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }



    public String getUrlNivel() {
        return urlNivel;
    }

    public void setUrlNivel(String urlNivel) {
        this.urlNivel = urlNivel;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
}
