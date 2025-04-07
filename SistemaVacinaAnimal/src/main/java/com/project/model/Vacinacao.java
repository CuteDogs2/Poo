import java.time.LocalDate;

class Vacinacao {
    private Animal animal ();
    private Vacina vacina ();
    private Veterinario veterinario ();
    private LocalDate dataAplicacao ();
    private String dosagem ();
    private String lote ();
    private String idFrasco();

    public void getAnimal();
    public void getVacina();
    public void getVeterinario();
    public void getDataAplicacao();
    public void getDosagem();
    public void getLote();
    public void getidFrasco();
    
    public void showVacinacao(){
        System.out.println("Animal: "+this.animal+", recebeu a vacina "+this.vacina+"na data de "+this.dataAplicacao+". Id: "+this.idFrasco);
    }
}
