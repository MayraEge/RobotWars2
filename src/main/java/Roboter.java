public abstract class Roboter extends RobotPlayer {
    public Roboter(int movement, int attackStrength, int attackRange, int health, int startX, int startY, int defense) {
        super(startX, startY, movement, attackStrength, attackRange, defense, health);
    }

    @Override
    public void attack(Roboter target) {
        int damage = this.attackStrength - target.getDefense();
        if (damage < 0) {
            damage = 0;
        }
        target.verliereLeben(damage);

        System.out.println("Roboter " + this.getAvatar() + " greift Roboter " + target.getAvatar() + "an und verursacht " + damage + " Schaden.");
        System.out.println("Roboter " + target.getAvatar() + " hat jetzt " + target.getLeben() + " Leben. ");

        if (target.istTot()) {
            System.out.println("Roboter " + target.getAvatar() + " wurde besiegt!");
            target.setTot(true);
        }
    }

    @Override
    public void setTot(boolean tot) {
        // Implementiere die Logik, wenn ein Roboter zerstört wird
    }
}
