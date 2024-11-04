public class Roboter implements Movable, Attackable {
    private int movement;
    private int attackStrength;
    private int attackRange;
    private int defense;
    private int health;
    private int x;
    private int y;

    public Roboter(int movement, int attackStrength, int attackRange, int health, int startX, int startY, int defense){
        this.movement = movement;
        this.attackStrength = attackStrength;
        this.attackRange = attackRange;
        this.health = health;
        this.defense = defense;
        this.x = startX;
        this.y = startY;
    }
    //getter und setter
    public int getMovement() { return movement; }
    public int getAttackStrength() { return attackStrength; }
    public int getAttackRange() { return attackRange; }
    public int getHealth() { return health; }
    public int getDefense() { return defense; }
    public int getX() {return x;}
    public int getY() {return y;}
    public void setX (int x) {this.x = y;}
    public void setY (int y) {this.y = y;}

    @Override
    public void attack(Roboter target){
        //Angriffslogik
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
}
