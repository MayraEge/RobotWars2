public class Roboter extends RobotPlayer {
    private Spielfeld spielfeld;
    private Spieler owner;

    public Roboter(int x, int y, int movement, int attackStrength, int attackRange, int health, Spielfeld spielfeld, Spieler owner) {
        super(x, y, movement, attackStrength, attackRange, health);
        this.spielfeld = spielfeld;
        this.owner = owner;
    }

    public Spieler getOwner() {
        return owner;
    }
    public void attack (Roboter target){
        if (this.isDestroyed()){
            System.out.println("Der zerstörte Roboter kann nicht angreifen. ");
            return;
        }
        if (target == null || target.isDestroyed()) {
            System.out.println("Das Ziel ist ungültig oder bereits zerstört.");
            return;
        }

        target.takeDamage(this.getAttackStrength());
        System.out.println("Roboter von " + this.owner.getName() + " greift Roboter von " + target.getOwner().getName() + " an und verursacht " + this.getAttackStrength() + " Schaden.");
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Roboter von " + owner.getName() + " nimmt " + damage + " Schaden. Übrige Gesundheit: " + getHealth());
    }
    @Override
    public boolean isDestroyed() {
        return getHealth() <= 0;
    }
}