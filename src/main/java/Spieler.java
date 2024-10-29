public class Spieler {
    public String getAvatar;
    private String name;
    private char avatar;
    private int x;
    private int y;
    private int leben;

    public Spieler(String name, char avatar, int startX, int startY) {
        this.name = name;
        this.avatar = avatar;
        this.x = startX;
        this.y = startY;
        this.leben = 2;
    }

    public String getName() {
        return name;
    }

    public char getAvatar() {
        return avatar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLeben() {
        return leben;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void verliereLeben() {
        if (leben > 0) {
            leben--;
        }
    }

    public boolean istTot() {
        return leben <= 0;
    }
}
