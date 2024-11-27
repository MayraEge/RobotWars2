public class Roboter extends RobotPlayer{
    //private Spielfeld spielfeld;


    public Roboter(int x, int y, int movement, int attackStrength, int attackRange, int health, Spielfeld spielfeld, Bewegung bewegung, Spieler owner) {
        super(x, y, movement, attackStrength, attackRange, health, spielfeld, bewegung);
    }

    public Spieler getOwner() {
        return owner;
    }
    @Override
    public void attack(Roboter target) {
        if (target == null || target.isDestroyed()) {
            System.out.println("Das Ziel ist ungültig oder bereits zerstört.");
            return;
        }
        int distance = Math.abs(target.getX() - getX()) + Math.abs(target.getX() - getY());
        if (distance <= getAttackRange()) {
            target.takeDamage(getAttackStrength());
            System.out.println("Roboter von Spieler" + owner.getName() + " greift Roboter von " + target.getOwner().getName() + " an und verursacht " + getAttackStrength() + " Schaden. ");
            if (target.isDestroyed()) {
                System.out.println("Der Roboter von Spieler " + target.getOwner().getName() + " wurde zerstört!");
            }
            // Entferne den Roboter vom Spielfeld
            //spielfeld.removeRobot(target.getX(), target.getY());
        } else {
            System.out.println("Ziel ist außerhalb der Angriffsreichweite! ");
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Roboter von " + owner.getName() + " nimmt " + damage + " Schaden. Übrige Gesundheit: " + getHealth());
    }

    public boolean isDeath() {
        return this.health == 0;
    }
}