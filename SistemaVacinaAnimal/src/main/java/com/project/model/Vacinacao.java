package com.project.model;




import java.time.LocalDate;

import com.project.model.pessoas.Veterinario;
import com.project.model.vacina.Vacina;




/**
 * Esta classe representa a vacinação, e cotém informações para identificação da mesma.
 * 
 * <p>Armazena o animal que recebeu a aplicação, a vacina aplicada, o veterinario que realizou a aplicação, data da aplicação, retorno da aplicação caso tenha, e a dosagem aplicada no animal.</p>
 */
public class Vacinacao {




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
    private float doseAplicada;

    /** ID do frasco utilizado na aplicação. */
    private String idFrascoUtilizado;




    //Construtor




    /**
     * Construtor da classe Vacinacao.
     * 
     * @param animal            Objeto Animal que irá receber a vacina.
     * @param vacina            Objeto Vacina que será aplicada no animal.
     * @param veterinario       Objeto Veterinário que irá aplicar a vacina.
     * @param dataAplicacao     Data da aplicação da vacina.
     * @param dataRetorno       Data de retorno da aplicação, caso tenha.
     * @param doseAplicada      Dose da vacina aplicada no animal.
     * @param idFrascoUtilizado ID do frasco da vacina utilizado na aplicação.
     */
    public Vacinacao(Animal animal, Vacina vacina, Veterinario veterinario, LocalDate dataAplicacao, LocalDate dataRetorno, float doseAplicada, String idFrascoUtilizado) {
        this.animal = animal;
        this.vacina = vacina;
        this.veterinario = veterinario;
        this.dataAplicacao = dataAplicacao;
        this.dataRetorno = dataRetorno;
        this.doseAplicada = doseAplicada;
        this.idFrascoUtilizado = idFrascoUtilizado;
    }




    //Métodos




    /**
     * Obtém o objeto Animal ao qual a vacina foi aplicada.
     * 
     * @return Objeto animal.
     */
    public Animal getAnimal() {
        return this.animal;
    }




    /**
     * Obtém o objeto Vacina que foi aplicada no animal.
     * 
     * @return Objeto Vacina.
     */
    public Vacina getVacina() {
        return this.vacina;
    }




    /**
     * Obtém o objeto Veterinario que aplicou a vacina.
     * 
     * @return Objeto Veterinario.
     */
    public Veterinario getVeterinario() {
        return this.veterinario;
    }




    /**
     * Obtém a data de aplicação da vacina.
     * 
     * @return Data de aplicação da vacina.
     */
    public LocalDate getDataAplicacao() {
        return this.dataAplicacao;
    }



    
    /**
     * Obtém a data de retorno para aplicação de nova dose da vacina.
     * 
     * @return Data de retorno.
     */

    public LocalDate getDataRetorno() {
        return this.dataRetorno;
    }




    /**
     * Obtém medida da dose aplicada em ml.
     * 
     * @return
     */
    public float getDoseAplicada() {
        return this.doseAplicada;
        //return this.doseAplicada * this.vacina.getDosagemPorKg()
    }




    /**
     * Obtém o ID do frasco.
     * 
     * @return ID do frasco.
     */
    public String getIdFrascoUtilizado() {
        return this.idFrascoUtilizado;
    }


   

    /**
     * Altera o objeto Animal ao qual a vacina foi aplicada.
     * 
     * @param animal Novo animal.
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }




    /**
     * Altera o objeto Vacina que foi aplicada no animal.
     * 
     * @param vacina Novo objeto Vacina.
     */
    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }




    /**
     * Altera o objeto Veterinario que aplicou a vacina.
     * 
     * @param veterinario Novo Objeto Veterinario.
     */
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }




    /**
     * Altera a data de aplicação da vacina.
     * 
     * @param dataAplicacao Nova data de aplicação da vacina
     */
    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }




    /**
     * Altera a data de retorno da aplicação de nova dose da vacina.
     * 
     * @param dataRetorno Nova data de aplicação.
     */
    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }




    /**
     * Altera a medida da dose aplicada em ml.
     * 
     * @param doseAplicada
     */
    public void setDoseAplicada(float doseAplicada) {
        this.doseAplicada = doseAplicada;
    }




    /**
     * Altera o ID do frasco utilizado.
     * 
     * @param idFrasco ID do frasco.
     */
    public void setIdFrascoUtilizado(String idFrascoUtilizado) {
        this.idFrascoUtilizado = idFrascoUtilizado;
    }
}