import java.time.LocalDate;

class Vacinacao {
    private Animal animal;
    private Vacina vacina;
    private Veterinario veterinario;
    private LocalDate dataAplicacao;
    private String dosagem;
    private String lote;
    private String idFrasc;

    Vacinacao(Animal animal, Vacina vacina, Veterinario veterinario, LocalDate dataAplicacao, String dosagem, String lote, String idFrasc){
        this.animal = animal;
        this.vacina = vacina;
        this.veterinario = veterinario;
        this.dataAplicacao = dataAplicacao;
        this.dosagem = dosagem;
        this.lote = lote;
        this.idFrasc = idFrasc;
    }
   
    public Vacina addVacina();
    public Animal addAnimal();
    public Animal getAnimal();
    public Vacina getVacina();
    public Veterinario getVeterinario();
    public LocalDate getDataAplicacao();
    public String getDosagem();
    public String getLote();
    public String getidFrasco();
    
    public void showVacinacao(){
        System.out.println("Animal: "+this.animal+", recebeu a vacina "+this.vacina+"na data de "+this.dataAplicacao+". Id: "+this.idFrasco);
    }
}
