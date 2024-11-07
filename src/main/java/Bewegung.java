public class Bewegung {
    private Spielfeld spielfeld;

    public Bewegung(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void moveRoboter(Roboter roboter, char direction) {
        int x = roboter.getX();
        int y = roboter.getY();
        spielfeld.removeRobot(x, y);

        switch (direction) {
            case 'w':
                x = (x > 0) ? x - 1 : x;
                break;
            case 's':
                x = (x < spielfeld.getSize() - 1) ? x + 1 : x;
                break;
            case 'a':
                y = (y > 0) ? y - 1 : y;
                break;
            case 'd':
                y = (y < spielfeld.getSize() - 1) ? y + 1 : y;
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Richtung: " + direction + ". Bitte (w/a/s/d) benutzen. ");
        }
        roboter.setX(x);
        roboter.setY(y);
        //roboter.move(x - roboter.getX(), y - roboter.getY());
        spielfeld.setRobot(x, y, roboter.getOwner().getAvatar());
    }
}
