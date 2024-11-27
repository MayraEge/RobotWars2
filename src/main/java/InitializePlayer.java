import java.util.Scanner;

public class InitializePlayer {
    public static Spieler initializePlayer(Scanner scanner, TankGame tankGame) {
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
        for (Color color : Color.values()) {
            System.out.println(color);
        }
        System.out.print("Wähle eine Farbe für deinen Avatar: ");
        String colorsName = scanner.nextLine().toUpperCase();
        Color selectedColor;
        try {
            selectedColor = Color.valueOf(colorsName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ungültige Farbe. Standardfarbe ROT wird gesetzt.");
            selectedColor = Color.RED;
        }
        tankGame.setColors(avatar, selectedColor);

        return new Spieler(name, avatar, selectedColor);
    }
}
