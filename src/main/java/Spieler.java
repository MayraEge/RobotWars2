public class Spieler {
    private char avatar;
    private String name;

    public Spieler(String name, char avatar) {
        this.avatar = avatar;
        this.name = name;
    }

    public char getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

}