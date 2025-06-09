package com.project.model.vacina;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




/**
 * Esta classe representa um lote, e contém informações para a identificação do mesmo.
 * 
 * <p>Armazena o ID do lote, validade do lote, lista de ID's das vacinas deste respectivo lote.</p>
 */
public class Lote {




    //Atributos




    /** ID do Lote. */
    private String idLote;

    /** ID da Vacina. */
    private String idVacina;

    /** Data de validade do lote.  */
    private LocalDate dataValidade;

    /** Lista de frascos pertencentes a este lote. */
    private List<Frasco> frascos;




    //Construtor



    /**
     * Construtor da classe Lote.
     * 
     * @param idLote            ID do Lote.
     * @param idVacina          ID da vacina.
     * @param dataValidade      Data de validade do lote.
     */
    public Lote (String idLote, String idVacina, LocalDate dataValidade) {
        this.idLote = idLote;
        this.dataValidade = dataValidade;
        this.idVacina = idVacina;

        this.frascos = new ArrayList<>();
    }




    /**
     * Construtor da classe Lote.
     * 
     * Utilizado para criar um lote sem uma lista de frascos e sem o ID de uma vacina.
     * 
     * @param idLote            ID do Lote.
     * @param dataValidade      Data de validade do lote.
     */
    public Lote (String idLote, LocalDate dataValidade) {
        this.idLote = idLote;
        this.dataValidade = dataValidade;

        this.frascos = new ArrayList<>();
    }




    //Métodos




    /**
     * Obtém o ID do lote da vacina.
     * 
     * @return  ID do lote.
     */
    public String getIdLote() {
        return this.idLote;
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
     * Obtém a validade do lote da vacina.
     * 
     * @return  Validade do lote.
     */
    public LocalDate getDataValidade() {
        return this.dataValidade;
    }




    /**
     * Obtém a lista de frascos pertencentes ao mesmo lote.
     * 
     * @return  Lista de frascos.
     */
    public List<Frasco> getFrascos() {
        return this.frascos;
    }




    /**
     * Altera o ID do lote.
     * 
     * @param idLote ID do lote.
     */
    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }




    /**
     * Altera o ID da vacina.
     * 
     * @param idVacina ID da vacina.
     */
    public void setIdVacina(String idVacina) {
        this.idVacina = idVacina;
    }




    /**
     * Altera a data de validade do lote.
     * 
     * @param dataValidade  Data de validade do lote.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }




    /**
     * Altera a lista de frascos pertencentes ao mesmo lote.
     * 
     * @param frascos   Lista de frascos.
     */
    public void setFrascos(List<Frasco> frascos) {
        this.frascos = frascos;
    }
}
