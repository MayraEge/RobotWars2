import java.util.Scanner;

public class Hauptspiel {
    private static boolean gameOver = false;
    public static Spieler spieler1;
    public static Spieler spieler2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zu Robot Wars!");
        System.out.println(" _____       _           _    _            _     _ ");
        System.out.println("|  __ \\     | |         | |  | |          | |   | |");
        System.out.println("| |__) |___ | |__   ___ | |  | | ___  _ __| | __| |");
        System.out.println("|  _  // _ \\| '_ \\ / _ \\| |  | |/ _ \\| '__| |/ _` |");
        System.out.println("| | \\ \\ (_) | |_) |  __/| |__| | (_) | |  | | (_| |");
        System.out.println("|_|  \\_\\___/|_.__/ \\___| \\____/ \\___/|_|  |_|\\__,_|");
        System.out.println();
        // do while schleife, fehlerausgabe, roboterauswahl

        Spielfeld spielfeld = new Spielfeld(10);
        //SP1
        String name1;
        do {
            System.out.println("Spieler 1, gib Deinen Namen ein (max. 8 Zeichen): ");
            name1 = scanner.nextLine();
            if (name1.length() > 8) {
                System.out.println("Der Name ist zu lang, bitte maximal 8 Zeichen, keine Sonderzeichen.");
            }
        } while (name1.length() > 8);

        System.out.println("Spieler 1, waehle Deinen Avatar (*, §, #, $): ");

        char avatar1 = scanner.next().charAt(0);
        int[] stats1 = waehleStats(scanner);

        spieler1 = new Spieler(0, 0, avatar1, spielfeld, stats1[0], stats1[1], stats1[2]);


        //SP2
        scanner.nextLine();
        String name2;
        do {
            System.out.println("Spieler 2, gib deinen Namen ein: ");
            name2 = scanner.nextLine();
            if (name2.length() > 8) {
                System.out.println("Der Name ist zu lang, bitte maximal 8 Zeichen, keine Sonderzeichen.");
            }
        } while (name2.length() > 8);
        //return name2;
        scanner.nextLine();
        System.out.println("Spieler 2, waehle Deinen Avatar (*, §, #, $): ");
        char avatar2 = scanner.next().charAt(0);

        int[] stats2 = waehleStats(scanner);

        spieler2 = new Spieler(9, 9, avatar2, spielfeld, stats2[0], stats2[1], stats2[2]);

        spielfeld.setzeSpieler(spieler1.getX(), spieler1.getY(), spieler1.getAvatar());
        spielfeld.setzeSpieler(spieler2.getX(), spieler2.getY(), spieler2.getAvatar());

        Bewegung bewegung = new Bewegung(spielfeld);
        Angriff angriff = new Angriff(spielfeld);

        SpielerManager spielerManager = new SpielerManager(spieler1, spieler2, spielfeld, bewegung, angriff);
        spielerManager.starteSpiel();
    }
    private static int[] waehleStats(Scanner scanner) {
        int movement, attackStrength, attackRange, defense, health;
        int totalPoints = 15;
//hier nochmal genauer schauen
        do {
            System.out.println("Verteile 15 Punkte auf Bewegung, Angriffsstärke und Verteidigung.");
            System.out.print("Bewegung: ");
            movement = scanner.nextInt();
            System.out.print("Angriffsstärke: ");
            attackStrength = scanner.nextInt();
            System.out.print("AngriffsReichweite: ");
            attackRange = scanner.nextInt();
            System.out.print("Verteidigung: ");
            defense = scanner.nextInt();
            System.out.print("Gesundheit: ");
            health = scanner.nextInt();


            if (movement + attackStrength + attackRange + defense + health > totalPoints) {
                System.out.println("Die Summe der Punkte darf 15 nicht überschreiten. Bitte erneut versuchen.");
            }
        } while (movement + attackStrength + attackRange + defense + health > totalPoints);

        return new int[]{movement + attackStrength + attackRange + defense + health };
    }
}


