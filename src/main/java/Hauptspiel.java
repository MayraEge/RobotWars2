import java.util.Scanner;
import java.util.Random;
import java.util.Objects;

public class Hauptspiel {
    private static Spielfeld spielfeld = new Spielfeld();
    private static Angriff angriff = new Angriff(spielfeld);
    private static Bewegung bewegung = new Bewegung(spielfeld);
    private static Spieler spieler1;
    private static Spieler spieler2;

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
        spieler1 = new Spieler(name1, avatar1, 0, 0);
        spielfeld.setzeSpieler(spieler1.getX(), spieler1.getY(), spieler1.getAvatar());

        //spieler 2
        System.out.println("Spieler 2, gib deinen Namen ein: ");
        scanner.nextLine(); //scanner leeren
        String name2 = scanner.nextLine();
        System.out.println("Spieler 2, waehle Deinen Avatar (*, §, #, $): ");
        char avatar2 = scanner.next().charAt(0);
        spieler2 = new Spieler(name2, avatar2, 9, 9);
        spielfeld.setzeSpieler(spieler2.getX(), spieler2.getY(), spieler2.getAvatar());

        while (true) {
            spielfeld.zeigeSpielfeld();
            System.out.println(spieler1.getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
            handleAktion(scanner.next().charAt(0), spieler1);
            if (spieler1.istTot() || spieler2.istTot()) break;
            spielfeld.zeigeSpielfeld();
            System.out.println(spieler2.getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
            handleAktion(scanner.next().charAt(0), spieler2);
            if (spieler1.istTot() || spieler2.istTot()) break;
        }
        System.out.println("Spiel beendet!");
    }

    private static void handleAktion(char aktion, Spieler spieler) {
        if (aktion == 'w' || aktion == 'a' || aktion == 's' || aktion == 'd') {
            Hauptspiel.bewegung.bewegeSpieler(spieler, aktion);
        } else if (aktion == 'i' || aktion == 'j' || aktion == 'k' || aktion == 'l') {
            Hauptspiel.angriff.greifeAn(spieler, aktion);
        }
    }
}
