import javax.swing.*;

public class Angriff {
    private Spielfeld spielfeld;
    private Bewegung bewegung;

    public Angriff(Spielfeld spielfeld, Bewegung bewegung) {
        this.spielfeld = spielfeld;
        this.bewegung = bewegung;
    }

    public void greifeAn(Roboter angreifer, char richtung) {
        int x = angreifer.getX();
        int y = angreifer.getY();

        switch (richtung) {
            case 'i':
                x = (x > 0) ? x - 1 : x;
                break;
            case 'k':
                x = (x < spielfeld.getSize() - 1) ? x + 1 : x;
                break;
            case 'j':
                y = (y > 0) ? y - 1 : y;
                break;
            case 'l':
                y = (y < spielfeld.getSize() - 1) ? y + 1 : y;
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Richtung: " + richtung);
        }
        System.out.println("Angreifer bewegt sich zu Position: (" + x + ", " + y + ")");

        if (spielfeld.istRoboterAufFeld(x, y)) {
            Roboter getroffenerRoboter = findeRoboter(x, y);
            if (getroffenerRoboter != null && getroffenerRoboter != angreifer) {
                executeAttack(angreifer, getroffenerRoboter);
            }
        } else {
            System.out.println("Kein Roboter auf Position: (" + x + ", " + y + ")");
        }
    }
    private Roboter findeRoboter(int x, int y) {
        char avatar = spielfeld.getRoboterAufFeld(x, y);
        for (Roboter roboter : spielfeld.getRoboterList()) {
            if (roboter.getOwner().getAvatar() == avatar) {
                return roboter;
            }
        }
        return null;
    }

    private void executeAttack(Roboter angreifer, Roboter getroffenerRoboter) {
        getroffenerRoboter.takeDamage(angreifer.getAttackStrength());
        System.out.println("Roboter von Spieler " + angreifer.getOwner().getName() + " hat den Roboter von Spieler " + getroffenerRoboter.getOwner().getName() + " getroffen!");
        System.out.println("Roboter von Spieler " + getroffenerRoboter.getOwner().getName() + " hat jetzt noch " + getroffenerRoboter.getHealth() + " Gesundheit.");

        if (getroffenerRoboter.isDestroyed()) {
            System.out.println("Roboter von Spieler " + getroffenerRoboter.getOwner().getName() + " wurde zerstört!");
            spielfeld.entferneRoboter(getroffenerRoboter.getX(), getroffenerRoboter.getY());
        }
    }

    public void attackCloseField(Roboter angreifer) {
        int x = angreifer.getX();
        int y = angreifer.getY();

        int[][] richtungen = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] richtung : richtungen) {
            int targetX = x + richtung[0];
            int targetY = y + richtung[1];

            if (targetX >= 0 && targetX < spielfeld.getSize() && targetY >= 0 && targetY < spielfeld.getSize()) {
                if (spielfeld.istRoboterAufFeld(targetX, targetY)) {
                    Roboter getroffenerRoboter = findeRoboter(targetX, targetY);
                    if (getroffenerRoboter != null && getroffenerRoboter != angreifer) {
                        System.out.println("Roboter gefunden auf benachbartem Feld: (" + targetX + ", " + targetY + ")");
                        executeAttack(angreifer, getroffenerRoboter);
                    }
                }
            }
        }
    }
}
