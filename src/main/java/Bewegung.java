public class Bewegung {
    private Spielfeld spielfeld;

    public Bewegung(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void bewegeSpieler(Spieler spieler, char richtung) {
        int x = spieler.getX();
        int y = spieler.getY();

        spielfeld.entferneSpieler(x, y);

        switch (richtung) {
            case 'w': x = (x > 0) ? x - 1 : x; break;
            case 's': x = (x < spielfeld.getSize() - 1) ? x + 1 : x; break;
            case 'a': y = (y > 0) ? y - 1 : y; break;
            case 'd': y = (y < spielfeld.getSize() - 1) ? y + 1 : y; break;
        }

        spieler.setPosition(x, y);
        spielfeld.setzeSpieler(x, y, spieler.getAvatar());
    }
}
