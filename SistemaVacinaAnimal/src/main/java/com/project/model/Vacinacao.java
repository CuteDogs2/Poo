import java.time.LocalDate;

class Vacinacao {
    private Animal animal;
    private Vacina vacina;
    private Veterinario veterinario;
    private LocalDate dataAplicacao;
    private LocalDate dataRetorno;
    private String dosagem;
    private String lote;
    private String idFrasc;

    Vacinacao(Animal animal, Vacina vacina, Veterinario veterinario, LocalDate dataAplicacao, LocalDate dataRetorno, String dosagem, String lote, String idFrasc){
        this.animal = animal;
        this.vacina = vacina;
        this.veterinario = veterinario;
        this.dataAplicacao = dataAplicacao;
        this.dataRetorno = dataRetorno;
        this.dosagem = dosagem;
        this.lote = lote;
        this.idFrasc = idFrasc;
    }
   
    public Animal setAnimal(){
        this.animal = animal;
    }
    public Vacina setVacina(){
        this.vacina = vacina;
    }
    public Veterinario setVeterinario(){
        this.veterinario = veterinario;
    }
    public LocalDate setDataAplicacao(){
        this.dataAplicacao = dataAplicacao;
    }
    public LocalDate setDataRetorno(){
        this.dataRetorno = dataRetorno;
    }
    public String setDosagem(){
        this.dosagem = dosagem;
    }
    public String setLote(){
        this.lote = lote;
    }
    public String setidFrasco(){
        this.idFrasco = idFrasco;
    }
    
    public LocalDate verificarDataRetorno(LocalDate dataRetorno){
        if(dataRetorno != NULL){
            return dataRetorno;
        } else{System.out.println("Sem data de retorno. Dose unica.");
            return NULL;
        }
    }

    public void showVacinacao(){
        System.out.println("Animal: "+this.animal+", recebeu a vacina "+this.vacina+"na data de "+this.dataAplicacao+". Id: "+this.idFrasco);
    }
}
