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

        SpielerManager spielerManager = new SpielerManager(roboterMap.get(spieler1.getAvatar()), roboterMap.get(spieler2.getAvatar()), spielfeld, bewegung, angriff);
        spielerManager.starteSpiel();
    }

    private static void initializePlayersandRobots(Scanner scanner, Spielfeld spielfeld) {
        System.out.println("Spieler 1:");
        spieler1 = InitializePlayer.initializePlayer(scanner);
        Roboter roboter1 = InitializeRoboter.initializeRoboter(scanner, 0, 0, spielfeld, spieler1);
        roboterMap.put(spieler1.getAvatar(), roboter1);

        System.out.println("Spieler 2:");
        spieler2 = InitializePlayer.initializePlayer(scanner);
        Roboter roboter2 = InitializeRoboter.initializeRoboter(scanner, 9, 9, spielfeld, spieler2);
        roboterMap.put(spieler2.getAvatar(), roboter2);

        spielfeld.setzeRoboter(roboter1.getX(), roboter1.getY(), spieler1.getAvatar());
        spielfeld.setzeRoboter(roboter2.getX(), roboter2.getY(), spieler2.getAvatar());

    }
}


