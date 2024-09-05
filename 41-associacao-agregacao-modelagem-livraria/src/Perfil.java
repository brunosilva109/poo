import java.util.ArrayList;
class Perfil {
    private String nome;
    private ArrayList<ListaDesejos> listasDeDesejos;

    public Perfil(String nome) {
        this.nome = nome;
        this.listasDeDesejos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<ListaDesejos> getListasDeDesejos() {
        return listasDeDesejos;
    }

    public ListaDesejos novaListaDesejos(String nome, boolean publica) {
        ListaDesejos novaLista = new ListaDesejos(nome, publica);
        listasDeDesejos.add(novaLista);
        return novaLista;
    }

    public ListaDesejos getListaDeDesejos(int indice) {
        if (indice >= 0 && indice < listasDeDesejos.size()) {
            return listasDeDesejos.get(indice);
        }
        return null;
    }

    public ListaDesejos getListaDeDesejos(String nome) {
        for (ListaDesejos lista : listasDeDesejos) {
            if (lista.getNome().equals(nome)) {
                return lista;
            }
        }
        return null;
    }
    
    public ArrayList<ListaDesejos> getListasDesejos() {
        return listasDeDesejos;
    }

    public ListaDesejos novaListaDeDesejos(String nome, boolean publica) {
        ListaDesejos novaLista = new ListaDesejos(nome, publica);
        listasDeDesejos.add(novaLista);
        return novaLista;
    }

    public ListaDesejos getListaDesejos(int indice) {
        if (indice >= 0 && indice < listasDeDesejos.size()) {
            return listasDeDesejos.get(indice);
        }
        return null;
    }

    public ListaDesejos getListaDesejos(String nome) {
        for (ListaDesejos lista : listasDeDesejos) {
            if (lista.getNome().equals(nome)) {
                return lista;
            }
        }
        return null;
    }
}