import java.util.List;
import java.util.ArrayList;

public class Spielfeld {
    private List<Spieler> spielers;
    private int size;
    private char[][] feld;

    public Spielfeld(int size) {
        this.size = size;
        this.feld = new char[size][size];
        this.spielers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                feld[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean istSpielerAufFeld(int x, int y) {
        return feld[x][y] != ' ';
    }

    public char getSpielerAufFeld(int x, int y) {
        return feld[x][y];
    }

    public void setzeSpieler(int x, int y, char avatar) {
        feld[x][y] = avatar;
    }

    public void entferneSpieler(int x, int y) {
        feld[x][y] = ' ';
    }

    public void zeigeSpielfeld() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (feld[i][j] == ' ') {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + feld[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    public boolean isFeldFrei(int x, int y) {
        return feld[x][y] == ' ';
    }

    public void addSpieler(Spieler spieler) {
        spielers.add(spieler);
    }

    public void removeSpieler(Spieler spieler) {
        spielers.remove(spieler);
    }

    public Spieler findeSpieler(char avatar) {
        for (Spieler spieler : spielers) {
            if (spieler.getAvatar() == avatar) {
                return spieler;
            }
        }
        return null;
    }
}
