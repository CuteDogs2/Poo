package com.project.model;




import java.time.LocalDate;




/**
 * Esta classe representa uma Vacina, e contém informações para a identificação da mesma.
 * 
 * <p>Armazena o nome da vacina, ID da vacina no sistema, ID do lote, fabricante, validade do lote, validade da aplicação, e dosagem por kg do animal.</p>
 */
public class Vacina {




    //Atributos




    /** Nome da vacina. */
    private String nomeVacina;

    /** ID da vacina. */
    private String idVacina;

    /** ID do frasco da vacina. */
    private String idFrascoVacina;

    /** ID do lote. */
    private String idLote;

    /** Nome do fabricante. */
    private String fabricante;

    /** Validade do lote. */
    private LocalDate validadeDoLote;

    /** Validade da aplicação em meses. */
    private String validadeDaAplicacao;

    /** Volume específico de aplicação da vacina em ml/kg do animal. */
    private float dosagemPorKg;

    /** Volume em ml contido no frasco da vacina. */
    private float volumeVacina;




    //Construtor




    /**
     * Construtor da classe Vacina.
     * 
     * @param nomeVacina            Nome da vacina.
     * @param idVacina              ID da vacina.
     * @param idFrascoVacina        ID do frasco da vacina.
     * @param idLote                ID do lote.
     * @param fabricante            Nome do fabricante.
     * @param validadeDoLote        Validade do lote.
     * @param validadeDaAplicacao   Validade da aplicação em meses (duração do efeito da imunidade).
     * @param dosagemPorKg          volume específico de aplicação da vacina em ml/kg do animal.
     * @param volumeVacina          Volume em ml contido no frasco da vacina.
     */
    public Vacina(String nomeVacina, String idVacina, String idFrascoVacina, String idLote, String fabricante, LocalDate validadeDoLote, String validadeDaAplicacao, float dosagemPorKg, float volumeVacina) {
        this.nomeVacina = nomeVacina;
        this.idVacina = idVacina;
        this.idFrascoVacina = idFrascoVacina;
        this.idLote = idLote;
        this.fabricante = fabricante;
        this.validadeDoLote = validadeDoLote;
        this.validadeDaAplicacao = validadeDaAplicacao;
        this.dosagemPorKg = dosagemPorKg;
        this.volumeVacina = volumeVacina;
    }



    
    //Métodos




    /**
     * Obtém o nome da vacina.
     * 
     * @return Nome da vacina.
     */
    public String getNomeVacina() {
        return this.nomeVacina;
    }




    /**
     * Obtém o ID da vacina.
     * 
     * @return ID da vacina.
     */
    public String getIdVacina() {
        return this.idVacina;
    }




    /**
     * Obtém o ID do frasco da vacina.
     * 
     * @return ID do frasco da vacina
     */
    public String idFrascoVacina() {
        return this.idFrascoVacina;
    }




    /**
     * Obtem o ID do lote.
     * 
     * @return ID do lote.
     */
    public String getIdLote() {
        return this.idLote;
    }





    /**
     * Obtém o nome do fabricante.
     * 
     * @return Nome do fabricante.
     */
    public String getFabricante() {
        return this.fabricante;
    }




    /**
     * Obtém a validade do lote.
     * 
     * 
     * @return Validade do lote.
     */
    public LocalDate getValidadeDoLote() {
        return this.validadeDoLote;
    }




    /**
     * Obtem a validade da aplicação da vacina em meses.
     * 
     * @return Validade da aplicação
     */
    public String getValidaDaAplicacao() {
        return this.validadeDaAplicacao;
    }




    /**
     * Obtém o volume específico de aplicação da vacina em ml/kg do animal.
     * 
     * @return Volume específico da aplicação em ml/kg.
     */
    public float getDosagemPorKg() {
        return this.dosagemPorKg;
    }




    /**
     * Obtém o volume em ml contido no frasco da vacina.
     * 
     * @return Volume em ml contido no frasco.
     */
    public float getVolumeVacina() {
        return this.volumeVacina;
    }




    /**
     * Altera o nome da vacina.
     * 
     * @param nomeVacina Novo nome da vacina.
     */
    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }




    /**
     * Altera o ID da vacina.
     * 
     * @param idVacina Novo ID da vacina.
     */
    public void setIdVacina(String idVacina) {
        this.idVacina = idVacina;
    }




    /**
     * Altera o ID do lote.
     * 
     * @param idLote Novo ID do lote.
     */
    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }




    /**
     * Altera o ID do frasco da vacina.
     * 
     * @param idFrascoVacina;
     */
    public void setIdFrascoVacina(String idFrascoVacina) {
        this.idFrascoVacina = idFrascoVacina;
    }




    /**
     * Altera o nome do fabricante.
     * 
     * @param fabricante Novo nome do fabricante.
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }




    /**
     * Altera a data de validade do lote.
     * 
     * @param validadeDoLote Nova validade do lote.
     */
    public void setValidadeDoLote(LocalDate validadeDoLote) {
        this.validadeDoLote = validadeDoLote;
    }




    /**
     * Altera a data de validade da aplicação em meses.
     * 
     * @param validadeDaAplicacao Nova validade da aplicação em meses.
     */
    public void setValidadeDaAplicacao(String validadeDaAplicacao) {
        this.validadeDaAplicacao = validadeDaAplicacao;
    }



    
    /**
     * Altera o volume específico da aplicação em ml/kg.
     * 
     * @param dosagemPorKg Novo volume específico em ml/kg.
     */
    public void setDosagemPorKg(float dosagemPorKg) {
        this.dosagemPorKg = dosagemPorKg;
    }




    /**
     * Altera o volume em ml contido no frasco da vacina.
     * 
     * @param volumeVacina Novo volume contido no frasco.
     */
    public void setVolumeVacina(float volumeVacina) {
        this.volumeVacina = volumeVacina;
    }
}