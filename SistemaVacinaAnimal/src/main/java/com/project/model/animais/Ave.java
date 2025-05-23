import java.time.LocalDate;
import com.project.model.pessoas.Cliente;



/**
 * Esta classe representa um animal da espécie ave, e contém informações para identificação do mesmo.
 * 
 * <p>Alem dos dados da classe animal, armazena a raça da ave, e contém métodos de acesso.</p>
 */
public class Ave extends Animal{




    //Atributos




    /** Raça da ave. */
    private String raca;




    //Construtor




    /**
     * Construtor da classe Ave.
     * 
     * @param raca              Raça da ave.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param dono              Cliente que é dono do animal.
     */
    public Ave(String raca, String idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, Cliente dono){
        super(idAnimal, nome, dataNascimento, sexo, peso, dono);
        this.raca = raca;
    }




    /**
     * Obtém a raça da ave.
     * 
     * @return Raça da ave.
     */
    public String getRaca(){
        return this.raca;
    }




    /**
     * Altera a raça da ave.
     * 
     * @param raca Nova raça da ave.
     */
    public void setRaca(String raca){
        this.raca = raca;
    }
}