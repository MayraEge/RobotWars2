import java.util.Scanner;

public class InitializePlayer {
    public static Spieler initializePlayer(Scanner scanner, SpielerManager spielerManager) {
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

        System.out.println("Verfügbare Farben: ");
        for (Colors colors : Colors.values()) {
            System.out.println(colors);
        }
        System.out.print("Wähle eine Farbe für deinen Avatar: ");
        String colorsName = scanner.nextLine().toUpperCase();
        Colors selectedColors;
        try {
            selectedColors = Colors.valueOf(colorsName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ungültige Farbe. Standardfarbe ROT wird gesetzt.");
            selectedColors = Colors.RED;
        }
        spielerManager.setColors(avatar, selectedColors);

        return new Spieler(name, avatar, selectedColors);
    }
}
