package com.project.model.vacina;




//import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;




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
    private int idVacina;

    /** Nome do fabricante. */
    private String fabricante;

    /** Validade da aplicação em meses. */
    private int validadeDaAplicacao;

    /** Volume específico de aplicação da vacina em ml/kg do animal. */
    private float dosagemPorKg;

    /** Lista de lotes de uma respectiva vacina registradas no sistema. */
    private List<Lote> lotes;



    //Construtor




    /**
     * Construtor da classe Vacina.
     * 
     * @param nomeVacina            Nome da vacina.
     * @param idVacina              ID da vacina.
     * @param fabricante            Nome do fabricante.
     * @param validadeDaAplicacao   Validade da aplicação em meses (duração do efeito da imunidade).
     * @param dosagemPorKg          volume específico de aplicação da vacina em ml/kg do animal.
     * @param lotes                 Lista de lotes de uma respectiva vacina registrada no sistema.
     * 
     */
    public Vacina(String nomeVacina, int idVacina, String fabricante, int validadeDaAplicacao, float dosagemPorKg) {
        this.nomeVacina = nomeVacina;
        this.idVacina = idVacina;
        this.fabricante = fabricante;
        this.validadeDaAplicacao = validadeDaAplicacao;
        this.dosagemPorKg = dosagemPorKg;
        this.lotes = new ArrayList<>();
    }




    /**
     * Construtor da classe Vacina sem o ID da vacina.
     * 
     * Utilizado para criar um objeto vacina sem o ID da vacina.
     * 
     * @param nomeVacina            Nome da vacina.
     * @param fabricante            Nome do fabricante.
     * @param validadeDaAplicacao   Validade da aplicação em meses (duração do efeito da imunidade).
     * @param dosagemPorKg          volume específico de aplicação da vacina em ml/kg do animal.
     * @param lotes                 Lista de lotes de uma respectiva vacina registrada no sistema.
     * 
     */
    public Vacina(String nomeVacina, String fabricante, int validadeDaAplicacao, float dosagemPorKg) {
        this.nomeVacina = nomeVacina;
        this.fabricante = fabricante;
        this.validadeDaAplicacao = validadeDaAplicacao;
        this.dosagemPorKg = dosagemPorKg;
        this.lotes = new ArrayList<>();
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
    public int getIdVacina() {
        return this.idVacina;
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
     * Obtem a validade da aplicação da vacina em meses.
     * 
     * @return Validade da aplicação
     */
    public int getValidadeDaAplicacao() {
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
     * Obtém uma lista de lotes de uma respectiva vacina registrados no sistema.
     * 
     * @return Lista de lotes.
     */
    public List<Lote> getLotes() {
        return this.lotes;
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
    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
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
     * Altera a data de validade da aplicação em meses.
     * 
     * @param validadeDaAplicacao Nova validade da aplicação em meses.
     */
    public void setValidadeDaAplicacao(int validadeDaAplicacao) {
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
     * Altera a lista de lotes de uma respectiva vacina registrados no sistema.
     * 
     * @param lote Lista de Lotes.
     */
    public void setLotes(List<Lote> lote){
        this.lotes = lote;
    }
}