
class Autor {
    private String nome;
    private String sobrenome;

    public Autor(String sobrenome, String nome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    String getNome(){
        return nome;
    }
    String getSobrenome(){
        return sobrenome;
    }
    String getNomeCompleto(){
        return nome + " " + sobrenome;

    }
    @Override
    public String toString() {
        return sobrenome+ ", " + nome;
    }


}
