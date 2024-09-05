import java.util.ArrayList;
class ListaDesejos {
    private String nome;
    private boolean publica;
    private ArrayList<Livro> livros;

    public ListaDesejos(String nome, boolean publica) {
        this.nome = nome;
        this.publica = publica;
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean isPublica() {
        return publica;
    }
    
    public boolean isPrivada() {
        if(publica == false){
            return true;
        }
        return publica;
    }

    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Livro getLivro(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            return livros.get(indice);
        }
        return null;
    }

    public int getQuantidade() {
        return livros.size();
    }

    public boolean isVazia() {
        return livros.isEmpty();
    }
}