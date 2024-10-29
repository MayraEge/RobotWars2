import java.util.Scanner;

public class SpielerManager {
    private Spieler spieler1;
    private Spieler spieler2;
    private Spielfeld spielfeld;
    private Bewegung bewegung;
    private Angriff angriff;
    private boolean gameOver;

    public SpielerManager(Spieler spieler1, Spieler spieler2, Spielfeld spielfeld, Bewegung bewegung, Angriff angriff) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.spielfeld = spielfeld;
        this.bewegung = bewegung;
        this.angriff = angriff;
        this.gameOver = false;
    }

    public void starteSpiel() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            spielfeld.zeigeSpielfeld();

            // Spieler 1
            if (!gameOver) {
                System.out.println(spieler1.getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                handleAktion(scanner.next().charAt(0), spieler1);
                if (spieler1.istTot() || spieler2.istTot()) gameOver = true;
            }

            // Spieler 2
            if (!gameOver) {
                spielfeld.zeigeSpielfeld();
                System.out.println(spieler2.getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                handleAktion(scanner.next().charAt(0), spieler2);
                if (spieler1.istTot() || spieler2.istTot()) gameOver = true;
            }
        }

        System.out.println("Spiel beendet!");
    }

    private void handleAktion(char aktion, Spieler spieler) {
        if (aktion == 'w' || aktion == 'a' || aktion == 's' || aktion == 'd') {
            bewegung.bewegeSpieler(spieler, aktion);
        } else if (aktion == 'i' || aktion == 'j' || aktion == 'k' || aktion == 'l') {
            angriff.greifeAn(spieler, aktion);
        }
    }
}
