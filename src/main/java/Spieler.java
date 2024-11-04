public class Spieler implements Movable, Attackable {
    private int x;
    private int y;
    private char avatar;
    private String name;
    private Spielfeld spielfeld;
    private boolean tot;
    private int leben;
    private int bewegung;
    private int angriff;
    private int verteidigung;

    public Spieler(int startX, int startY, char avatar, Spielfeld spielfeld, int bewegung, int angriff, int verteidigung) {
        this.x = startX;
        this.y = startY;
        this.avatar = avatar;
        this.spielfeld = spielfeld;
        this.tot = false;
        this.leben = 10; // Beispiel: Jeder Spieler startet mit 10 Leben
        this.bewegung = bewegung;
        this.angriff = angriff;
        this.verteidigung = verteidigung;
        spielfeld.setzeSpieler(x, y, avatar);
        spielfeld.addSpieler(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getAvatar() {
        return avatar;
    }

    public boolean istTot() {
        return tot;
    }

    public void setTot(boolean tot) {
        this.tot = tot;
    }

    public int getLeben() {
        return leben;
    }

    public int getBewegung() {
        return bewegung;
    }

    public int getAngriff() {
        return angriff;
    }

    public int getVerteidigung() {
        return verteidigung;
    }

    public void verliereLeben(int schaden) {
        if (leben > 0) {
            leben -= schaden;
            if (leben <= 0) {
                leben = 0;
                setTot(true);
                spielfeld.removeSpieler(this);
            }
        }
    }

    @Override
    public void move(char direction) {
        // Die Bewegungslogik wird in der Bewegung-Klasse gehandhabt
    }

    @Override
    public void attack(Roboter target) {
        // Angriffslogik
    }
}
