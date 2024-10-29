public class Spielfeld {
    private static final int SIZE = 10;
    private char[][] feld;

    public Spielfeld() {
        feld = new char[SIZE][SIZE];
        initialisiereSpielfeld();
    }

    private void initialisiereSpielfeld() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                feld[i][j] = '.';
            }
        }
    }

    public void setzeSpieler(int x, int y, char spieler) {
        feld[x][y] = spieler;
    }

    public void zeigeSpielfeld() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFeldFrei(int x, int y) {
        return feld[x][y] == '.';
    }

    public int getSize() {
        return SIZE;
    }
}
