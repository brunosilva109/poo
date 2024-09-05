
class Editora {
    private String editoraNome;

    public Editora(String nome) {
        this.editoraNome = nome;
    }
    String getNome(){
        return editoraNome;
    }
    @Override
    public String toString() {
        return editoraNome;
    }

}
