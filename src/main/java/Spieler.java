public class Spieler implements Movable, Attackable {
    public String getAvatar;
    private int x;
    private int y;
    private char avatar;
    private String name;
    private Spielfeld spielfeld;
    private boolean tot;
    private int health;
    private int movement;
    private int attackStrength;
    private int attackRange;
    private int defense;

    public Spieler(int startX, int startY, char avatar, Spielfeld spielfeld, int bewegung, int angriff, int verteidigung) {
        this.x = startX;
        this.y = startY;
        this.avatar = avatar;
        this.spielfeld = spielfeld;
        this.tot = false;
        this.health = 10; // Beispiel: Jeder Spieler startet mit 10 Leben
        this.movement = bewegung;
        this.attackStrength = angriff;
        this.defense = verteidigung;
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

    public void verliereLeben(int schaden) {
        if (health > 0) {
            health -= schaden;
            if (health <= 0) {
                health = 0;
                setTot(true);
                spielfeld.removeSpieler(this);
            }
        }
    }

    @Override
    public void move(int deltaX, int deltaY) {

    }

    @Override
    public void move(char direction) {
        // Die Bewegungslogik wird in der Bewegung-Klasse gehandhabt
    }

    @Override
    public void attack(Roboter target) {
        // Angriffslogik
    }

    public String getName() {
        return name;
    }
}
