import java.util.Objects;

public class Dinheiro implements Comparable<Dinheiro> {
    private int reais;
    private int centavos;

    public Dinheiro(int reais, int centavos) {
        this.reais = reais;
        this.centavos = centavos;
    }

    public Dinheiro(double dinheiro) {
        this.reais = (int) dinheiro;
        this.centavos = (int) ((dinheiro - this.reais) * 100);
    }

    public Dinheiro() {
        this.reais = 0;
        this.centavos = 0;
    }

    public Dinheiro(int reais) {
        this.reais = reais;
        this.centavos = 0;
    }

    public Dinheiro(Dinheiro A) {
        this.reais = A.reais;
        this.centavos = A.centavos;
    }

    public Dinheiro(String dinheiro) {
        dinheiro = dinheiro.replaceAll("R\\$", "");
        dinheiro = dinheiro.replaceAll("\\.", "");
        dinheiro = dinheiro.replaceAll(",", ".").trim();
        double Dinheiro = Double.valueOf(dinheiro).doubleValue();
        reais = (int) (Dinheiro);
        centavos = (int) (Dinheiro * 100) - ((int) (Dinheiro) * 100);
    }

    public void somar(int soma) {
        this.reais = this.reais + soma;
    }

    public void somar(Dinheiro soma) {
        this.reais = this.reais + soma.reais;
        this.centavos = this.centavos + soma.centavos;
    }

    public void somar(String dinheiro) {
        dinheiro = dinheiro.replaceAll("R\\$", "");
        dinheiro = dinheiro.replaceAll("\\.", "");
        dinheiro = dinheiro.replaceAll(",", ".").trim();
        double Dinheiro = Double.valueOf(dinheiro).doubleValue();
        Dinheiro = Dinheiro + (double) reais + ((double) centavos / 100);
        reais = (int) (Dinheiro);
        centavos = (int) (Dinheiro * 100) - ((int) (Dinheiro) * 100);
    }

    public void somar(double dinheiro) {
        dinheiro = dinheiro + (double) reais + ((double) centavos / 100);
        this.reais = (int) dinheiro;
        this.centavos = (int) ((dinheiro - this.reais) * 100);
    }

    int getReais() {
        return reais;
    }

    int getCentavos() {
        return centavos;
    }

    public void imprimir() {
        String reaisFormatado = String.format("%,d", reais);
        String centavosFormatado = String.format("%02d", centavos);
        System.out.println("R$ " + reaisFormatado + "," + centavosFormatado);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Dinheiro dinheirO = (Dinheiro) obj;
        return reais == dinheirO.reais && centavos == dinheirO.centavos;
    }
    

    @Override
    public int compareTo(Dinheiro other) {
        if (this.reais != other.reais) {
            return Integer.compare(this.reais, other.reais);
        }
        return Integer.compare(this.centavos, other.centavos);
    }
    @Override
    public String toString() {
        return String.format("R$ %d,%02d", reais, centavos);
    }

}
