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

    createVacinacao{
        addVacina
        addAnimal 
    }
    
    public Vacina addVacina();
    public Animal addAnimal();
    public void getAnimal();
    public void getVacina();
    public void getVeterinario();
    public void getDataAplicacao();
    public void getDosagem();
    public void getLote();
    public void getidFrasco();
}