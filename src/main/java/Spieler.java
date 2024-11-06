import java.awt.*;

public class Spieler {
    private char avatar;
    private String name;
    private Colors colors;

    public Spieler(String name, char avatar, Colors colors) {
        this.avatar = avatar;
        this.name = name;
        this.colors =  colors;
    }

    public char getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public Colors getColors(){
        return colors;
    }

}