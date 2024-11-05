public class Spieler extends RobotPlayer {
    private char avatar;
    private String name;
    private Spielfeld spielfeld;
    private boolean tot;

    public Spieler(int startX, int startY, char avatar, Spielfeld spielfeld, int bewegung, int angriff, int reichweite, int verteidigung, int gesundheit) {
        super(startX, startY, bewegung, angriff, reichweite, verteidigung, gesundheit);
        this.avatar = avatar;
        this.spielfeld = spielfeld;
        this.tot = false;
        spielfeld.setzeSpieler(x, y, avatar);
        spielfeld.addSpieler(this);
    }

    public char getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setTot(boolean tot) {
        this.tot = tot;
        if (tot) {
            spielfeld.removeSpieler(this);
        }
    }

    @Override
    public void attack(Roboter target) {

    }

    @Override
    public int getLeben() {
        return 0;
    }

}
