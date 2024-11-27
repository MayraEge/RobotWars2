import java.util.Scanner;

public class GameLoop {
    private Spielfeld gameboard;
    private Spieler[] players;


    public GameLoop(Spielfeld gameboard, Spieler[] players) {
        this.gameboard = gameboard;
        this.players = players;

    }

    public void start() {
        boolean gameOver = false;
        do {
            for (Spieler player : players) {
                Roboter roboter = player.getRoboter();
                System.out.println(player.getRoboter().getOwner().getName() + ", bewege dich (w/a/s/d) oder greife an (i/j/k/l): ");
                char actionDirection = scanner.next().charAt(0);
                if (actionDirection == 'w' || actionDirection == 'a' || actionDirection == 's' || actionDirection == 'd') {
                    roboter.move(actionDirection);
                } else if (actionDirection == 'i' || actionDirection == 'j' || actionDirection == 'k' || actionDirection == 'l') {
                    gameboard.tryAttack(roboter,actionDirection); //TODO make robot attack with the actionDirection
                } else {
                    System.out.println("Ungültige Eingabe. Bitte versuche es erneut.");
                }
                gameboard.zeigeSpielfeld(players); //TODO make playfield use playerarray to work
                if (roboter.isTot()) {
                    gameOver = true;
                    System.out.println("Spieler " + roboter.getOwner().getName() + " hat verloren!");
                    break;
                }
            }

        } while (!gameOver);

    }
}

