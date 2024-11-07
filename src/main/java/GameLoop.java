import java.util.Scanner;

public class GameLoop {
    private RobotManager robotManager;
    private Spielfeld spielfeld;
    private SpielerManager spielerManager;
    private Angriff angriff;
    private boolean gameOver;

    public GameLoop(RobotManager robotManager, Spielfeld spielfeld, SpielerManager spielerManager, Angriff angriff) {
        this.robotManager = robotManager;
        this.spielfeld = spielfeld;
        this.spielerManager = spielerManager;
        this.angriff = angriff;
        this.gameOver = false;
    }

    public void start(Scanner scanner) {
        while (!gameOver) {
            for (Roboter roboter : robotManager.getRobots()) {
                System.out.println(roboter.getOwner().getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                char action = scanner.next().charAt(0);
                if (action == 'w' || action == 'a' || action == 's' || action == 'd') {
                    robotManager.moveRobot(roboter, action);
                } else if (action == 'i' || action == 'j' || action == 'k' || action == 'l') {
                    angriff.attack(roboter, action);
                } else {
                    System.out.println("Ungültige Eingabe. Bitte versuche es erneut.");
                }
                spielfeld.zeigeSpielfeld(spielerManager);
                if (roboter.isDestroyed()) {
                    gameOver = true;
                    System.out.println("Spieler " + roboter.getOwner().getName() + " hat verloren!");
                    break;
                }
            }
        }
    }
}

