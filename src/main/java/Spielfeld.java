import java.util.List;
import java.util.ArrayList;

public class Spielfeld {
    private List<Roboter> roboterList;
    private int size;
    private char[][] feld;

    public Spielfeld(int size) {
        this.size = size;
        this.feld = new char[size][size];
        this.roboterList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                feld[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean istRoboterAufFeld(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: (" + x + ", " + y + ")");
        }
            boolean result = feld[x][y] != ' ';
            System.out.println("istRoboterAufFeld(" + x + ", " + y + "): ");
            return result;
    }

    public char getRoboterAufFeld(int x, int y) {
        return feld[x][y];
    }

    public void setzeRoboter(int x, int y, char avatar) {
        System.out.println("Setze Spieler an Position: (" + x + ", " + y + ")");
        feld[x][y] = avatar;
    }

    public void entferneRoboter(int x, int y) {
        System.out.println("Entferne Spieler von Position: (" + x + ", " + y + ")");
        feld[x][y] = ' ';
        roboterList.removeIf(roboter -> roboter.getX() == x && roboter.getY() == y);
    }

    public void zeigeSpielfeld() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (feld[i][j] == ' ') {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + feld[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    public boolean isFeldFrei(int x, int y) {
        return feld[x][y] == ' ';
    }

    public void addRoboter(Roboter roboter) {
        roboterList.add(roboter);
    }

    public void removeRoboter(Roboter roboter) {
        roboterList.remove(roboter);
    }

    public Roboter findeRoboter(char avatar) {
        for (Roboter roboter : roboterList) {
            System.out.println("Überprüfe Roboter mit Avatar: " + roboter.getOwner().getAvatar());
            if (roboter.getOwner().getAvatar() == avatar) {
                return roboter;
            }
        }
        return null;
    }
    public List<Roboter>getRoboterList(){
        return roboterList;
    }
}
