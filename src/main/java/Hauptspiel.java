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

        RobotManager robotManager = new RobotManager(spielfeld);

        Bewegung bewegung = new Bewegung(spielfeld);

        SpielerManager spielerManager = initializePlayersandRobots(scanner, robotManager, bewegung);

        Roboter roboter1 = roboterMap.get(spieler1.getAvatar());
        Roboter roboter2 = roboterMap.get(spieler2.getAvatar());

        spielerManager.setRoboter1(roboter1);
        spielerManager.setRoboter2(roboter2);

        spielerManager.starteSpiel();

        spielfeld.zeigeSpielfeld(spielerManager);

        GameLoop gameLoop = new GameLoop(robotManager, spielfeld, spielerManager, roboter1);
        gameLoop.start(scanner);
    }

        private static SpielerManager initializePlayersandRobots(Scanner scanner, RobotManager robotManager, Bewegung bewegung) {
        Spielfeld spielfeld = robotManager.getSpielfeld();
        SpielerManager spielerManager = new SpielerManager(null, null, spielfeld, bewegung, null, scanner);

        System.out.println("Hallo, Spieler 1:");
        spieler1 = InitializePlayer.initializePlayer(scanner, spielerManager);
        Roboter roboter1 = InitializeRoboter.initializeRoboter(scanner, 0, 0, spielfeld, spieler1);
        roboterMap.put(spieler1.getAvatar(), roboter1);
        robotManager.addRobot(roboter1);

        System.out.println("Hallo, Spieler 2:");
        spieler2 = InitializePlayer.initializePlayer(scanner, spielerManager);
        Roboter roboter2 = InitializeRoboter.initializeRoboter(scanner, 9, 9, spielfeld, spieler2);
        roboterMap.put(spieler2.getAvatar(), roboter2);
        robotManager.addRobot(roboter2);

        spielfeld.setRobot(roboter1.getX(), roboter1.getY(), spieler1.getAvatar());
        spielfeld.setRobot(roboter2.getX(), roboter2.getY(), spieler2.getAvatar());

            spielerManager.setRoboter1(roboter1);
            spielerManager.setRoboter2(roboter2);

            return spielerManager;
    }
}
