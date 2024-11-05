public class Bewegung {
    private Spielfeld spielfeld;

    public Bewegung(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void moveRoboter(Roboter roboter, char richtung) {
        int x = roboter.getX();
        int y = roboter.getY();

        spielfeld.entferneRoboter(x, y);

        switch (richtung) {
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
                throw new IllegalArgumentException("Ungueltige Richtung: " + richtung + ". Bitte (w/a/s/d) benutzen. ");
        }
        roboter.move(x - roboter.getX(), y - roboter.getY());
        spielfeld.setzeRoboter(x, y, roboter.getOwner().getAvatar());
    }
}
