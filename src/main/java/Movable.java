public interface Movable {
    void move(int deltaX, int deltaY);
    void move(char direction);
}

    public void move(Movable obj, char richtung) {
        obj.move(richtung);
    }
}

public class Spieler implements Movable {
    private int x;
    private int y;
    private char avatar;
    private Spielfeld spielfeld;

    public Spieler(int x, int y, char avatar, Spielfeld spielfeld) {
        this.x = x;
        this.y = y;
        this.avatar = avatar;
        this.spielfeld = spielfeld;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        int newX = x + deltaX;
        int newY = y + deltaY;
        if (newX >= 0 && newX < spielfeld.getSize() && newY >= 0 && newY < spielfeld.getSize()) {
            spielfeld.entferneSpieler(x, y);
            x = newX;
            y = newY;
            spielfeld.setzeSpieler(x, y, avatar);
        }
    }

    @Override
    public void move(char direction) {
        switch (direction) {
            case 'w':
                move(-1, 0);
                break;
            case 's':
                move(1, 0);
                break;
            case 'a':
                move(0, -1);
                break;
            case 'd':
                move(0, 1);
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Richtung: " + direction);
        }
    }
}
