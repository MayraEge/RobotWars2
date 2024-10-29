public class Spielfeld {
    private int size = 10;
    private char[][] feld;

    public Spielfeld(int size) {
        this.size = size;
        this.feld = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                feld[i][j] = ' ';
            }
        }
    }
    public int getSize() {
        return size;
    }
    public boolean istSpielerAufFeld(int x, int y){
        return feld[x][y] != ' ';
    }

    public char getSpielerAufFeld(int x, int y) {
        return feld[x][y];
    }
    public void setzeSpieler(int x, int y, char avatar) {
        feld[x][y] = avatar;
    }
    public void entferneSpieler(int x, int y){
        feld[x][y] = ' ';
    }
    public void zeigeSpielfeld() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (feld[i][j] == ' '){
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + feld [i][j] + "]");
                }
            }
            System.out.println();
        }
    }
public boolean isFeldFrei(int x, int y){
    return feld[x][y]== ' ';
    }
}