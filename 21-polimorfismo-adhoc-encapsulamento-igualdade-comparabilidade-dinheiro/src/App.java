class App {
    public static void main(String[] args) {
        
        Dinheiro d1 = new Dinheiro(); // construtor vazio significa R$ 0,00
        System.out.println(d1.getReais() == 0);
        System.out.println(d1.getCentavos() == 0);

        Dinheiro d3 = new Dinheiro(3, 45); // três reais e 45 centavos
        System.out.println(d3.getReais() == 3);
        System.out.println(d3.getCentavos() == 45);

        Dinheiro d2 = new Dinheiro(d3); // d2 recebe os valores de d3, R$ 3,45
        System.out.println(d2.getReais() == 3);
        System.out.println(d2.getCentavos() == 45);

        Dinheiro d4 = new Dinheiro(200); // duzentos reais
        System.out.println(d4.getReais() == 200);
        System.out.println(d4.getCentavos() == 0);

        Dinheiro d5 = new Dinheiro("R$ 345,75"); // trezentos e quarenta e cinco reais e setenta e cinco centavos
        System.out.println(d5.getReais() == 345);
        System.out.println(d5.getCentavos() == 75);

        Dinheiro d6 = new Dinheiro("R$ 1.000.000,11"); // um milhão de reais com onze centavos
        System.out.println(d6.getReais() == 1000000);
        System.out.println(d6.getCentavos() == 11);

        Dinheiro d7 = new Dinheiro("R$ 2.567,89");
        System.out.println(d7.getReais() == 2567);
        System.out.println(d7.getCentavos() == 89);

        d3.somar(d4); // somar o valor de d4 em d3
        System.out.println(d3.getReais() == 203);
        System.out.println(d3.getCentavos() == 45);

        d5.somar(100);
        System.out.println(d5.getReais() == 445);
        System.out.println(d5.getCentavos() == 75);

        d6.somar(1.90);
        System.out.println(d6.getReais() == 1000002);
        System.out.println(d6.getCentavos() == 01);
        d6.imprimir(); // R$ 1.000.002,01

        d7.somar("R$ 998.817,86");
        System.out.println(d7.getReais() == 1001385);
        System.out.println(d7.getCentavos() == 75);
        d7.imprimir(); // R$ 1.001.385,75

        Dinheiro d8  = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
        Dinheiro d9  = new Dinheiro(8, 99); // oito reais com noventa e nove centavos
        Dinheiro d10 = null; // nulo
        Dinheiro d11 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
        Dinheiro d12 = d8; // mesma identidade de d8

        System.out.println(d8.equals(d9)  == false);
        System.out.println(d8.equals(d10) == false);
        System.out.println(d8.equals(d11) == true);
        System.out.println(d8.equals(d12) == true);

        System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
        System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
        System.out.println( ! new Dinheiro("R$ 5,43").equals(null)); // nunca é igual a null
        Dinheiro d13 = new Dinheiro(4, 30);
        Dinheiro d14 = new Dinheiro(987, 14);
        Dinheiro d15 = new Dinheiro(0, 1);
        Dinheiro d16 = new Dinheiro(17, 9);
        Dinheiro d17 = new Dinheiro(4, 30);

        // Todas estas assertivas devem imprimir true, claramente.
        System.out.println(d13.compareTo(d14) < 0);
        System.out.println(d13.compareTo(d15) > 0);
        System.out.println(d13.compareTo(d16) < 0);
        System.out.println(d13.compareTo(d17) == 0);

        Comparable d18 = new Dinheiro(8);
        Comparable d19 = new Dinheiro(9);
        Comparable d20 = new Dinheiro(8);
        System.out.println(d18.compareTo(d19) < 0);
        System.out.println(d18.compareTo(d20) == 0);
        System.out.println(d19.compareTo(d18) > 0);

        Dinheiro[] dinheiros = {d13, d14, d15, d16, d17};

        // 👈 código para classificar em ordem crescente através de java.util.Arrays
        java.util.Arrays.sort(dinheiros);

        System.out.println(java.util.Arrays.toString(dinheiros)); // "stringuifica" o array de dinheiros

        System.out.println(dinheiros[0].equals(d15));
        System.out.println(dinheiros[1].equals(d13));
        System.out.println(dinheiros[2].equals(d13));
        System.out.println(dinheiros[3].equals(d16));
        System.out.println(dinheiros[4].equals(d14));
    }
}
