package src;

class MaquinaAgua {
    private int bombonaDagua = 20000; // 20 litros
    private int copos200 = 100;
    private int copos300 = 100;

    void servirCopo200() {
        if (bombonaDagua < 200 && copos200 <= 0) {
            System.out.println("Sem Copos e agua");
        } else if (bombonaDagua < 200) {
            System.out.println("Sem agua");
        } else if (copos200 <= 0) {
            System.out.println("Sem Copos");
        } else {
            bombonaDagua = bombonaDagua - 200;
            copos200--;
        }
    }

    void servirCopo300() {
        if (bombonaDagua < 300 && copos200 <= 0) {
            System.out.println("Sem Copos e agua");
        } else if (bombonaDagua < 300) {
            System.out.println("Sem agua");
        } else if (copos300 <= 0) {
            System.out.println("Sem Copos");
        } else {
            bombonaDagua = bombonaDagua - 300;
            copos300--;
        }
    }

    void abastecerAgua() {
        bombonaDagua = 20000;
    }
    void abastecerCopo200(){
        copos200 = 100;
    }
    void abastecerCopo300(){
        copos300 = 100;
    }
}
