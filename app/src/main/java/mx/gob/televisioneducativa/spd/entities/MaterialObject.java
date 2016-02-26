package mx.gob.televisioneducativa.spd.entities;

/**
 * Created by JITOLEDO on 09/11/2015.
 */
public class MaterialObject {
    private String guiaEstudio;
    private String dimension;
    private String bibliografia;
    private String urlMaterial;

    public MaterialObject(String guiaEstudio, String dimension,String bibliografia, String urlMaterial){
        this.setGuiaEstudio(guiaEstudio);
        this.setDimension(dimension);
        this.setBibliografia(bibliografia);
        this.setUrlMaterial(urlMaterial);
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



    public String getUrlMaterial() {
        return urlMaterial;
    }

    public void setUrlMaterial(String urlMaterial) {
        this.urlMaterial = urlMaterial;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
}
