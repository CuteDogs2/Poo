import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Pessoa {
    //atributos
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String sexo;
    private String email;
    //contrutor
    public Pessoa(String nome, String cpf, int idade, String telefone, String sexo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.sexo = sexo;
        this.email = email;
    }
    //METODOS ESPECIAIS
    //verifico se o cpf tem o tamanho correto
    public void verificarEmail(String email){
        //estou passando o formato do email para a variável regex
        String formato = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //compilando para que possa ser comparado posteiomente
        Pattern pattern = Pattern.compile(formato);
        //agora estou validadondo o email digitado
        Matcher validar = pattern.matcher(email);
        if(validar.matches()){
            System.out.println("Email validado!");
            setEmail(email);
        }else{
            System.out.println("Email inválido!!");
        }
    }
    public void verificaCpf(String cpf) {
        if (cpf.length() != 11) {
            System.out.println("CPF inválido, tente novamente.");
        } else {
            setCpf(cpf);
        }
    }
    //verifica se o número de telefone é valido
    public void verificaTelefone(String telefone) {
        if (telefone.length() != 11) {
            System.out.println("Número de Telefone inválido, tente outro.");
        } else {
            setTelefone(telefone);
        }
    }
    // verificando a validade do atrada do sexo
    //compara as strings e o tamanho delas
    public void verificarSexo(String sexo) {
        if (!(sexo.toUpperCase().equals("MASCULINO") && sexo.length() == 9
                || sexo.toUpperCase().equals("FEMININO") && sexo.length() == 8)) {
            System.out.println("Sexo inválido!");
        } else {
            setSexo(sexo);
        }
    }
    //funções gette e sette
    public void setEmail(String email){
        this.email = email;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return this.sexo;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
