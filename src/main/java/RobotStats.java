import java.util.Scanner;

public class RobotStats {
    public static int[] waehleStats(Scanner scanner) {
        int movement, attackStrength, attackRange, health;
        int totalPoints = 15;

    do {
        System.out.println("Verteile 15 Punkte auf Bewegung, Angriffsstärke, Reichweite und Gesundheit.");
        System.out.print("Bewegung: ");
        movement = scanner.nextInt();
        System.out.print("Angriffsstärke: ");
        attackStrength = scanner.nextInt();
        System.out.print("AngriffsReichweite: ");
        attackRange = scanner.nextInt();
        System.out.print("Gesundheit: ");
        health = scanner.nextInt();


        if (movement + attackStrength + attackRange +  health > totalPoints) {
            System.out.println("Die Summe der Punkte darf 15 nicht überschreiten. Bitte erneut versuchen.");
        }
    } while (movement + attackStrength + attackRange +  health > totalPoints);
    scanner.nextLine();
    return new int[]{movement, attackStrength, attackRange, health };
}
}
