import java.util.List;
import java.util.ArrayList;

public class Spielfeld {
    private List<Roboter> roboterList;
    private int size;
    private char[][] gamefield;

    public Spielfeld(int size) {
        this.size = size;
        this.gamefield = new char[size][size];
        this.roboterList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gamefield[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getHeight() {
        return size;
    }

    public int getWidth(){
        return size;
    }

    public boolean istRoboterAufFeld(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: (" + x + ", " + y + ")");
        }
            boolean result = gamefield[x][y] != ' ';
            System.out.println("istRoboterAufFeld(" + x + ", " + y + "): ");
            return result;
    }

    public char getRoboterAufFeld(int x, int y) {
        return gamefield[x][y];
    }

    public void setRobot(int x, int y, char avatar) {
        System.out.println("Setze Spieler an Position: (" + x + ", " + y + ")");
        gamefield[x][y] = avatar;
    }

    public void removeRobot(int x, int y) {
        System.out.println("Entferne Spieler von Position: (" + x + ", " + y + ")");
        gamefield[x][y] = ' ';
        roboterList.removeIf(roboter -> roboter.getX() == x && roboter.getY() == y);
    }
    public Roboter getPosition(int x, int y) {
        for (Roboter roboter : roboterList) {
            if (roboter.getX() == x && roboter.getY() == y) {
                return roboter;
            }
        }
        return null;
    }

    public void zeigeSpielfeld(Spieler[] players) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char avatar = gamefield[i][j];
                if (avatar == ' ') {
                    System.out.print("[ ]");
                } else {
                    Color color = players.getColors(avatar);
                    if (color != null){
                        System.out.print("[" + color + avatar + Color.RESET + "]");
                    } else {
                        System.out.print("[" + avatar + "]");
                    }

                }
            }
            System.out.println();
        }
    }

    public boolean isFeldFrei(int x, int y) {
        return gamefield[x][y] == ' ';
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

    public void tryAttack(Roboter roboter, char actionDirection) {
        List<Roboter> currentEnemyRobots;
        for(Roboter r : roboterList) {
            currentEnemyRobots.add(r);
        }
        currentEnemyRobots.remove(roboter);
        int xCoordinate = roboter.getX();
        int yCoordinate = roboter.getY();
        int range = roboter.getAttackRange();
        switch (actionDirection) {
            case 'i':
                if(gamefield.isRobotPresent(xCoordinate,yCoordinate,yCoordinate+range)){ //TODO implement Method to check for Robots on coordinates
                    gamefield.damageRobots(xCoordinate,yCoordinate,yCoordinate+range); //TODO implement Method to damage Robots on coordinates
            }
            case 'j':
            case 'k':
            case 'l':
        }

    }
}
