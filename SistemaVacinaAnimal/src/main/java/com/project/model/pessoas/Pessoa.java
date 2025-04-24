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

    //funções get e set
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
        return this.cpf;
    }
}
