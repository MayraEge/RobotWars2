import java.util.Scanner;

public class InitializePlayer {
    public static Spieler initializePlayer(Scanner scanner) {
        String name;
        do {
            System.out.println("Gib deinen Namen ein (max. 8 Zeichen): ");
            name = scanner.nextLine();
            if (name.length() > 8) {
                System.out.println("Der Name ist zu lang, bitte maximal 8 Zeichen, keine Sonderzeichen.");
            }
        }
        while (name.length() > 8);

        System.out.println("Wähle deinen Avatar (*/§/#/$): ");
        char avatar = scanner.next().charAt(0);
        scanner.nextLine();

        return new Spieler(name, avatar, Colors);
    }
}
