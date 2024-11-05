import java.util.Scanner;

public class Hauptspiel {
    private static boolean gameOver = false;
    public static Spieler spieler1;
    public static Spieler spieler2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AsciiArt.printWelcomeMessage();

        Spielfeld spielfeld = new Spielfeld(10);

        System.out.println("Spieler 1:");
        spieler1 = InitializePlayer.initializePlayer(scanner, 0, 0, spielfeld);

        System.out.println("Spieler 2:");
        spieler2 = InitializePlayer.initializePlayer(scanner, 9, 9, spielfeld);

        spielfeld.setzeSpieler(spieler1.getX(), spieler1.getY(), spieler1.getAvatar());
        spielfeld.setzeSpieler(spieler2.getX(), spieler2.getY(), spieler2.getAvatar());

        Bewegung bewegung = new Bewegung(spielfeld);
        Angriff angriff = new Angriff(spielfeld);

        SpielerManager spielerManager = new SpielerManager(spieler1, spieler2, spielfeld, bewegung, angriff);
        spielerManager.starteSpiel();
    }
}


