class MaquinaAgua {
    private int agua = 0; // 20 litros
    private int copos200 = 0;
    private int copos300 = 0;

    void servirCopo200() {
        if (agua < 200 && copos200 <= 0) {
            System.out.println("Sem Copos e agua");
        } else if (agua < 200) {
            System.out.println("Sem agua");
        } else if (copos200 <= 0) {
            System.out.println("Sem Copos");
        } else {
            agua = agua - 200;
            copos200--;
        }
    }

    void servirCopo300() {
        if (agua < 300 && copos300 <= 0) {
            System.out.println("Sem Copos e agua");
        } else if (agua < 300) {
            System.out.println("Sem agua");
        } else if (copos300 <= 0) {
            System.out.println("Sem Copos");
        } else {
            agua = agua - 300;
            copos300--;
        }
    }

    void abastecerAgua() {
        agua = 20000;
    }
    void abastecerCopo200(){
        copos200 = 100;
    }
    void abastecerCopo300(){
        copos300 = 100;
    }
    int agua(){
        return agua;
    }
    int copos200(){
        return copos200;
    }
    int copos300(){
        return copos300;
    }
}
