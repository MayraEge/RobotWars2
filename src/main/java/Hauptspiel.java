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

        System.out.println("Spieler 1, gib Deinen Namen ein: ");
        String name1 = scanner.nextLine();
        System.out.println("Spieler 1, waehle Deinen Avatar (*, §, #, $): ");
        char avatar1 = scanner.next().charAt(0);
        Spieler spieler1 = new Spieler(name1, avatar1, 0, 0);

        System.out.println("Spieler 2, gib deinen Namen ein: ");
        scanner.nextLine(); // Scanner leeren
        String name2 = scanner.nextLine();
        System.out.println("Spieler 2, waehle Deinen Avatar (*, §, #, $): ");
        char avatar2 = scanner.next().charAt(0);
        Spieler spieler2 = new Spieler(name2, avatar2, 9, 9);

        Spielfeld spielfeld = new Spielfeld(10);
        spielfeld.setzeSpieler(spieler1.getX(), spieler1.getY(), spieler1.getAvatar());
        spielfeld.setzeSpieler(spieler2.getX(), spieler2.getY(), spieler2.getAvatar());

        Bewegung bewegung = new Bewegung(spielfeld);
        Angriff angriff = new Angriff(spielfeld);

        SpielerManager spielerManager = new SpielerManager(spieler1, spieler2, spielfeld, bewegung, angriff);
        spielerManager.starteSpiel();
    }
}

