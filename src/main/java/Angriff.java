public class Angriff {
    private Spielfeld spielfeld;

    public Angriff(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void greifeAn(Spieler angreifer, char richtung) {
        int x = angreifer.getX();
        int y = angreifer.getY();

        switch (richtung) {
            case 'i':
                x = (x > 0) ? x - 1 : x;
                break;
            case 'k':
                x = (x < spielfeld.getSize() - 1) ? x + 1 : x;
                break;
            case 'j':
                y = (y > 0) ? y - 1 : y;
                break;
            case 'l':
                y = (y < spielfeld.getSize() - 1) ? y + 1 : y;
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Richtung: " + richtung);
        }

        if (spielfeld.istSpielerAufFeld(x, y)) {
            char getroffenerAvatar = spielfeld.getSpielerAufFeld(x, y);

            Spieler getroffenerSpieler = findeSpieler(getroffenerAvatar);
            if (getroffenerSpieler != null) {
                getroffenerSpieler.verliereLeben();

                System.out.println("Spieler " + angreifer.getAvatar + " hat Spieler " + getroffenerAvatar + " getroffen!");
                System.out.println("Spieler " + getroffenerAvatar + " hat jetzt " + " Leben.");
                if (getroffenerSpieler.istTot()) {
                    System.out.println("Spieler " + getroffenerAvatar + " ist tot!");

                    spielfeld.entferneSpieler(getroffenerSpieler.getX(), getroffenerSpieler.getY());
                }
                //hier muss noch mehr Kampflogik eingefuegt werden/verbessert werden
            }
        } else {
            System.out.println("Angriff verfehlt!");
        }
    }

    private Spieler findeSpieler(char avatar) {
        if (Hauptspiel.spieler1.getAvatar() == avatar) {
            return Hauptspiel.spieler1;
        } else if (Hauptspiel.spieler2.getAvatar() == avatar) {
            return Hauptspiel.spieler2;
        }
        return null;
    }
}

