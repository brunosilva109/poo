import java.util.*;

public class Pessoa {
  private String nome;
  private int Amigos = 0;
  private List<Pessoa> amigosArray = new ArrayList<>();

  public Pessoa(String nome) {
    this.nome = nome;
  }
  @Override
  public String toString() {
    return nome;
  }

  public int getContagemAmigos() {
    return Amigos;
  }

  public void adicionaAmigo(Pessoa amigo) {
    if(amigo == this){
      return;
    }
    if (!amigosArray.contains(amigo)) {
      amigosArray.add(amigo);
      amigo.adicionaAmigo(this);
    }
  }

  public List<Pessoa> getAmigos() {
    return amigosArray;
  }

  public Pessoa getAmigo(int amigo) {
    return (amigosArray.size() < amigo + 1)? null : amigosArray.get(amigo);
  }

  public void removeAmigo(Pessoa amigo) {
    amigosArray.remove(amigo);
  }
  
  public void removeAmigo(int amigo) {
    amigosArray.remove(amigo);
  }

}
