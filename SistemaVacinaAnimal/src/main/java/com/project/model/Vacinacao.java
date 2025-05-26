import java.time.LocalDate;



/**
 * Esta classe representa a vacinação, e cotém informações para identificação da mesma.
 * 
 * <p>Armazena o animal que recebeu a aplicação, a vacina aplicada, o veterinario que realizou a aplicação, data da aplicação, retorno da aplicação caso tenha, e a dosagem aplicada no animal.</p>
 */
class Vacinacao {




    //Atributos




    /** Objeto animal que receberá a aplicação. */
    private Animal animal;

    /** Objeto vacina, a vacina a ser aplicada. */
    private Vacina vacina;

    /** Objeto veterinário, que irá aplicar a vacina. */
    private Veterinario veterinario;

    /** Data de aplicação da vacina. */
    private LocalDate dataAplicacao;

    /** Data de retorno da aplicação, caso tenha. */
    private LocalDate dataRetorno;

    /** Dosagem da aplicação; */
    private String dosagem;




    //Construtor




    /**
     * Construtor da classe Vacinacao.
     * 
     * @param animal            Objeto Animal que irá receber a vacina.
     * @param vacina            Objeto Vacina que será aplicada no animal.
     * @param veterinario       Objeto Veterinário que irá aplicar a vacina.
     * @param dataAplicacao     Data da aplicação da vacina.
     * @param dataRetorno       Data de retorno da aplicação, caso tenha.
     */
    Vacinacao(Animal animal, Vacina vacina, Veterinario veterinario, LocalDate dataAplicacao, LocalDate dataRetorno){
        this.animal = animal;
        this.vacina = vacina;
        this.veterinario = veterinario;
        this.dataAplicacao = dataAplicacao;
        this.dataRetorno = dataRetorno;
    }



    //Métodos




    /**
     * Obtém o objeto Animal ao qual a vacina foi aplicada.
     * 
     * @return Objeto animal.
     */
    public Animal getAnimal(){
        return this.animal;
    }




    /**
     * Obtém o objeto Vacina que foi aplicada no animal.
     * 
     * @return Objeto Vacina.
     */
    public Vacina getVacina(){
        return this.vacina;
    }




    /**
     * Obtém o objeto Veterinario que aplicou a vacina.
     * 
     * @return Objeto Veterinario.
     */
    public Veterinario getVeterinario(){
        return this.veterinario;
    }




    /**
     * Obtém a data de aplicação da vacina.
     * 
     * @return Data de aplicação da vacina.
     */
    public LocalDate getDataAplicacao(){
        return this.dataAplicacao;
    }



    
    /**
     * Obtem a data de retorno para aplicação de nova dose da vacina.
     * 
     * @return Data de retorno.
     */

    public LocalDate getDataRetorno(){
        return this.dataRetorno;
    }


   

    /**
     * Altera o objeto Animal ao qual a vacina foi aplicada.
     * 
     * @param animal Novo animal.
     */
    public void setAnimal(Animal animal){
        this.animal = animal;
    }




    /**
     * Altera o objeto Vacina que foi aplicada no animal.
     * 
     * @param vacina Novo objeto Vacina.
     */
    public void setVacina(Vacina vacina){
        this.vacina = vacina;
    }




    /**
     * Altera o objeto Veterinario que aplicou a vacina.
     * 
     * @param veterinario Novo Objeto Veterinario.
     */
    public void setVeterinario(Veterinario veterinario){
        this.veterinario = veterinario;
    }




    /**
     * Altera a data de aplicação da vacina.
     * 
     * @param dataAplicacao Nova data de aplicação da vacina
     */
    public void setDataAplicacao(LocalDate dataAplicacao){
        this.dataAplicacao = dataAplicacao;
    }




    /**
     * Altera a data de retorno da aplicação de nova dose da vacina.
     * 
     * @param dataRetorno Nova data de aplicação.
     */
    public void setDataRetorno(LocalDate dataRetorno){
        this.dataRetorno = dataRetorno;
    }

    // need func to check if table exist and create if false
    public String insertVacinacao(String table, Vacinacao entidade){
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("O nome da tabela não pode ser nulo ou vazio.");
        }

        //esse é o comando gerado pelo workbench:
        //INSERT INTO `clinica`.`vacinacao` (`dataAplicacao`, `dataRetorno`, `vacina_Id_frasco`, `carteira_animal_idanimal`, `veterinario_crmv`, `vacina_id_vacina`) VALUES ('01/03/2024', '01/04/2024', '1', 'sim', '123', '1');

        String cmdIdvacina = this.vacina.getIdVacina;
        String cmdIdfrasco = this.vacina.getIdFrasco;
        String cmdVetcrmv = this.veterinario.getCrmvVeterinario;
        String cmdAnimal = this.animal.getIdAnimal;
        String comando = "INSERT INTO " + table +
        " (`dataAplicacao`, `dataRetorno`, `vacina_Id_frasco`, `carteira_animal_idanimal`, `veterinario_crmv`, `vacina_id_vacina`) " +
        "VALUES (" +
        "'" + this.dataAplicacao "', " +
        "'" + this.dataRetorno "', " +
        "'" + this.cmdIdvacina "', " +
        "'" + this.cmdIdfrasco "', " +
        "'" + this.cmdVetcrmv "', " +
        "'" + this.cmdAnimal "'" +
        ");";

        return comando;
    }
}