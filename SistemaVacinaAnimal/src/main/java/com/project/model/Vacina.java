class Vacina{

    //atributos

    String nomeVacina;
    String fabricante;
    String lote;
    LocalDate validadeDoLote;
    float dosagemPorKg;

    //construtor
    Vacina(String nomeVacina, String fabricante, String lote, LocalDate validadeDoLote, float dosagemPorKg){
        this.nomeVacina = nomeVacina;
        this.fabricante = fabricante;
        this.lote = lote;
        this.validadeDoLote = validadeDoLote;
        this.dosagemPorKg = dosagemPorKg;
    }

    //metodos

    String getNomeVacina(){
        return this.nomeVacina;
    }

    String getFabricante(){
        return this.fabricante;
    }

    String getLote(){
        return this.lote;
    }

    LocalDate getValidadeDoLote(){
        return this.lote;
    }

    float getDosagemPorKg(){
        return this.dosagemPorKg;
    }
}