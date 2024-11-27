public class Spieler {
    private char avatar;
    private String name;
    private Color color;
    private Roboter roboter;

    public Spieler(String name, char avatar, Color color) {
        this.avatar = avatar;
        this.name = name;
        this.color = color;
    }

    public void setRoboter(Roboter roboter) {
        this.roboter = roboter;
    }

    public Roboter getRoboter() {
        return roboter;
    }

    public char getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public Color getColors() {
        return color;
    }

}