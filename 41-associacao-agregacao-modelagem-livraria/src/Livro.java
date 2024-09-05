
public class Livro {
    private final String titulo;
    private final Autor autor;
    private final int ano;
    private final Editora editora;

    public Livro(String titulo, Autor autor, int ano, Editora editora) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
    }
    String getTitulo(){
        return titulo;
    }
    Autor getAutor(){
        return autor;
    }
    int getAno(){
        return ano;
    }
    Editora getEditora(){
        return editora;
    }
    @Override
    public String toString() {
        return autor + ". " + titulo + ". Ed. "+ editora + ", " + ano + ".";
    }

}
