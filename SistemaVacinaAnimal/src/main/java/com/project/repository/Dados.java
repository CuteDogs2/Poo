// a ideia é que aqui teria um arquivo para controlar toda a integração com o banco de dados
// seguindo aquelas imagens exemplo em organização git no notion

// em teoria teria que ter uma dessas para cada classe
/* public String insertVacinacao(String table, Vacinacao entidade){
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
    } */
    // assim:
    /* public String insertVacina(String table, Vacina entidade);
    public String insertAnimal(String table, Animal entidade);
    public String insertVeterinario(String table, Veterinario entidade); */