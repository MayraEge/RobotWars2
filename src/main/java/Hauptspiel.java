import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hauptspiel {
    private static boolean gameOver = false;
    public static Map<Character, Roboter> roboterMap = new HashMap<>();
    public static Spieler spieler1;
    public static Spieler spieler2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AsciiArt.printWelcomeMessage();

        Spielfeld spielfeld = new Spielfeld(10);

        initializePlayersandRobots(scanner, spielfeld);

        Bewegung bewegung = new Bewegung(spielfeld);
        Angriff angriff = new Angriff(spielfeld, bewegung);

        Roboter roboter1 = roboterMap.get(spieler1.getAvatar());
        Roboter roboter2 = roboterMap.get(spieler2.getAvatar());

        SpielerManager spielerManager = new SpielerManager(roboter1, roboter2, spielfeld, bewegung, angriff);
        spielerManager.starteSpiel();
    }

    private static void initializePlayersandRobots(Scanner scanner, Spielfeld spielfeld) {
        SpielerManager spielerManager = new SpielerManager(null, null, spielfeld, null, null);

        System.out.println("Spieler 1:");
        spieler1 = InitializePlayer.initializePlayer(scanner, spielerManager);
        Roboter roboter1 = InitializeRoboter.initializeRoboter(scanner, 0, 0, spielfeld, spieler1);
        roboterMap.put(spieler1.getAvatar(), roboter1);

        System.out.println("Spieler 2:");
        spieler2 = InitializePlayer.initializePlayer(scanner, spielerManager);
        Roboter roboter2 = InitializeRoboter.initializeRoboter(scanner, 9, 9, spielfeld, spieler2);
        roboterMap.put(spieler2.getAvatar(), roboter2);

        spielfeld.setzeRoboter(roboter1.getX(), roboter1.getY(), spieler1.getAvatar());
        spielfeld.setzeRoboter(roboter2.getX(), roboter2.getY(), spieler2.getAvatar());

        spielerManager = new SpielerManager(roboter1, roboter2, spielfeld, new Bewegung(spielfeld), new Angriff(spielfeld, new Bewegung(spielfeld)));
    }
}
