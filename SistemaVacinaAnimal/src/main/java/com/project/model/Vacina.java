import java.time.LocalDate;




/**
 * Esta classe representa uma Vacina, e contem informações para a identificação da mesma.
 * 
 * <p>Armazena o nome da vacina, ID da vacina no sistema, ID do lote, fabricante, validade do lote, validade da aplicação, e dosagem por kg do animal.
 */
public class Vacina{




    //atributos




    /** Nome da vacina. */
    private String nomeVacina;

    /** ID da vacina. */
    private String idVacina;

    /** ID do lote. */
    private String idLote;

    /** Nome do fabricante. */
    private String fabricante;

    /** Validade do lote. */
    private LocalDate validadeDoLote;

    /** Validade da aplicação em meses. */
    private String validadeDaAplicacao;

    /** volume específico de aplicação da vacina em ml/kg do animal. */
    private float dosagemPorKg;




    //construtor




    /**
     * Construtor da classe Vacina.
     * 
     * @param nomeVacina            Nome da vacina.
     * @param idVacina              ID da vacina.
     * @param idLote                ID do lote.
     * @param fabricante            Nome do fabricante.
     * @param validadeDoLote        Validade do lote.
     * @param validadeDaAplicacao   Validade da aplicação em meses (duração do efeito da imunidade).
     * @param dosagemPorKg          volume específico de aplicação da vacina em ml/kg do animal.
     */
    Vacina(String nomeVacina, String idVacina, String idLote, String fabricante, LocalDate validadeDoLote, String validadeDaAplicacao, float dosagemPorKg){
        this.nomeVacina = nomeVacina;
        this.idVacina = idVacina;
        this.idLote = idLote;
        this.fabricante = fabricante;
        this.validadeDoLote = validadeDoLote;
        this.validadeDaAplicacao = validadeDaAplicacao;
        this.dosagemPorKg = dosagemPorKg;
    }

    //metodos




    /**
     * Obtém o nome da vacina.
     * 
     * @return Nome da vacina.
     */
    String getNomeVacina(){
        return this.nomeVacina;
    }




    /**
     * Obtém o ID da vacina.
     * 
     * @return ID da vacina.
     */
    String getIdVacina(){
        return this.idVacina;
    }



    /**
     * Obtem o ID do lote.
     * 
     * @return ID do lote.
     */
    String getIdLote(){
        return this.IdLote;
    }





    /**
     * Obtém o nome do fabricante.
     * 
     * @return Nome do fabricante.
     */
    String getFabricante(){
        return this.fabricante;
    }




    /**
     * Obtém a validade do lote.
     * 
     * 
     * @return Validade do lote.
     */
    LocalDate getValidadeDoLote(){
        return this.validadeDoLote;
    }




    /**
     * Obtem a validade da aplicação da vacina em meses.
     * 
     * @return Validade da aplicação
     */
    String getValidaDaAplicacao(){
        return this.validadeDaAplicacao;
    }




    /**
     * Obtém o volume específico de aplicação da vacina em ml/kg do animal.
     * 
     * @return Volume específico da aplicação em ml/kg.
     */
    float getDosagemPorKg(){
        return this.dosagemPorKg;
    }




    /**
     * Altera o nome da vacina.
     * 
     * @param nomeVacina Novo nome da vacina.
     */
    void setNomeVacina(String nomeVacina){
        this.nomeVacina = nomeVacina;
    }




    /**
     * Altera o ID da vacina.
     * 
     * @param idVacina Novo ID da vacina.
     */
    void setIdVacina(String idVacina){
        this.idVacina = idVacina;
    }




    /**
     * Altera o ID do lote.
     * 
     * @param idLote Novo ID do lote.
     */
    void setIdLote(String idLote){
        this.idLote = idLote;
    }




    /**
     * Altera o nome do fabricante.
     * 
     * @param fabricante Novo nome do fabricante.
     */
    void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }




    /**
     * Altera a data de validade do lote.
     * 
     * @param validadeDoLote Nova validade do lote.
     */
    void setValidadeDoLote(String validadeDoLote){
        this.validadeDoLote = validadeDoLote;
    }




    /**
     * Altera a data de validade da aplicação em meses.
     * 
     * @param validadeDaAplicacao Nova validade da aplicação em meses.
     */
    void setValidadeDaAplicacao(String validadeDaAplicacao){
        this.validadeDaAplicacao = validadeDaAplicacao;
    }



    
    /**
     * Altera o volume específico da aplicação em ml/kg.
     * 
     * @param dosagemPorKg Novo volume específico em ml/kg.
     */
    void setDosagemPorKg(String dosagemPorKg){
        this.dosagemPorKg = dosagemPorKg;
    }
}