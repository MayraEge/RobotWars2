import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpielerManager {
    private Roboter roboter1;
    private Roboter roboter2;
    private Spielfeld spielfeld;
    private Bewegung bewegung;
    private Angriff angriff;
    private boolean gameOver;
    private Map<Character, Colors> spielerColors;

    //Konstruktor
    public SpielerManager(Roboter roboter1, Roboter roboter2, Spielfeld spielfeld, Bewegung bewegung, Angriff angriff) {
        this.roboter1 = roboter1;
        this.roboter2 = roboter2;
        this.spielfeld = spielfeld;
        this.bewegung = bewegung;
        this.angriff = angriff;
        this.gameOver = false;
        this.spielerColors = new HashMap<>();
    }
    public void setColors(char avatar, Colors colors) {
        spielerColors.put(avatar, colors);
    }

    public Colors getColors(char avatar) {
        return spielerColors.get(avatar);
    }

    public void starteSpiel() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            // Spieler 1
            if (!gameOver) {
                System.out.println(roboter1.getOwner().getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                handleAktion(scanner.next().charAt(0), roboter1);
                spielfeld.zeigeSpielfeld(this);
                if (roboter1.isDestroyed() || roboter2.isDestroyed()) {
                    gameOver = true;
                    System.out.println("Spiel beendet! Ein Roboter wurde zerstört.");
                    break;
                }
            }

            // Spieler 2
            if (!gameOver) {
                spielfeld.zeigeSpielfeld(this);
                System.out.println(roboter2.getOwner().getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                handleAktion(scanner.next().charAt(0), roboter2);
                if (roboter1.isDestroyed() || roboter2.isDestroyed()) {
                    gameOver = true;
                    System.out.println("Spiel beendet! Ein Roboter wurde zerstört.");
                    break;
                }
            }
        }
        System.out.println("Spiel beendet!");
    }

    private void handleAktion(char aktion, Roboter roboter) {
        if (aktion == 'w' || aktion == 'a' || aktion == 's' || aktion == 'd') {
            bewegung.moveRoboter(roboter, aktion);
        } else if (aktion == 'i' || aktion == 'j' || aktion == 'k' || aktion == 'l') {
            angriff.greifeAn(roboter, aktion);
            angriff.attackCloseField(roboter); // Checke und greife benachbarte Felder an
        }
    }
}
