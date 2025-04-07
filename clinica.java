class Pessoa{
    private String nome;
    private String cpf;
    private int rg;
    private String telefone;

    // public Pessoa(){}

    public Pessoa(String nome, String cpf, int rg, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
    }

    public String toString(){
        return "Nome: "+this.nome+", CPF: "+this.cpf+", RG: "+Integer.toString(this.rg)+", Tel: "+this.telefone;
    }
}

class Lista<T>{
  private Object valores[]; //Vetor genérico - O java limita a criação de vetores genéricos.
                            //Alguns objetos permitem a utilização do polimorfismo por inclusão, já outros não.
                            //Contudo, na geração do bytecode é definida uma regra para substituição do tipo genérico
                            //por um tipo específico real. Assim, se é definido um vetor de tipos genéricos não há
                            //como fazer uma conversão direta.
                            //Desta forma, utilizamos um vetor do tipo Object, o qual representa o objeto pai de todos.
  private int maxTam;
  private int tam;

  public Lista(int maxTam){
    this.maxTam = maxTam;
    this.valores = (T[]) new Object[maxTam]; //Instancia-se um vetor de Objects e se faz a conversão para o vetor do tipo genérico
    this.tam=0;
  }

  public void add(T valor){
    if (this.tam<this.maxTam){
      this.valores[this.tam]=valor;
      this.tam++;
    }
  }

  public void print(){
    System.out.print("Lista: [");
    for (int i=0;i<this.tam;i++){
      System.out.print(" ["+this.valores[i].toString()+"]");
    }
    System.out.println(" ]");
  }
}

class Clinica{
    public static void main(String args[]){
        Pessoa p = new Pessoa("Carlos","03786909148",1111,"99415147");
        System.out.println(p.toString());
    }
}