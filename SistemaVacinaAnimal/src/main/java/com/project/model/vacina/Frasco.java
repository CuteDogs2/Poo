package com.project.model.vacina;



/**
 * Esta classe representa um frasco, e contém informações para a identificação do mesmo.
 * 
 * <p>Armazena o ID do frasco, ID do lote, volume do frasco em ml.</p>
 */
public class Frasco {
    



    //Atributos




    /** ID do frasco. */
    private String idFrasco;

    /** Volume do frasco. */
    private float volumeFrasco;

    /** ID do lote pertencente. */
    private String idLote;




    //Construtor




    /**
     * Construtor da classe Frasco.
     * 
     * @param idFrasco          ID do frasco.
     * @param volumeFrasco      Volume do frasco.
     */
    public Frasco (String idFrasco, float volumeFrasco, String idLote) {
        this.idFrasco = idFrasco;
        this.volumeFrasco = volumeFrasco;
        this.idLote = idLote;
    }




    //Métodos




    /**
     * Obtém o ID do frasco.
     * 
     * @return ID do frasco.
     */
    public String getIdFrasco() {
        return this.idFrasco;
    }




    /**
     * Obtém o volume contido no frasco em ml.
     * 
     * @return volume contido no frasco.
     */
    public float getVolumeFrasco() {
        return this.volumeFrasco;
    }




    /**
     * Obtém o ID do lote ao qual este frasco pertence.
     * 
     * @return ID do lote.
     */
    public String getIdLote() {
        return this.idLote;
    }




    /**
     * Altera o ID do frasco.
     * 
     * @param idFrasco ID do frasco.
     */
    public void setIdFrasco(String idFrasco) {
        this.idFrasco = idFrasco;
    }




    /**
     * Altera o volume do frasco.
     * 
     * @param volumeFrasco Volume do frasco.
     */
    public void setVolumeFrasco(float volumeFrasco) {
        this.volumeFrasco = volumeFrasco;
    }




    /**
     * Altera o ID do lote ao qual este frasco pertence.
     * 
     * @param idLote ID Lote.
     */
    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }
}
