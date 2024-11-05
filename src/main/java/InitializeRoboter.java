import java.util.Scanner;

public class InitializeRoboter {
    public static Roboter initializeRoboter(Scanner scanner, int startX, int startY, Spielfeld spielfeld, Spieler owner) {
        System.out.println("Verteile die Statuswerte für deinen Roboter:");
        int[] stats = RobotStats.waehleStats(scanner);

        int movement = stats[0];
        int attackStrength = stats[1];
        int attackRange = stats[2];
        int health = stats[3];

        return new Roboter(startX, startY, movement, attackStrength, attackRange, health, spielfeld, owner);
    }
}

