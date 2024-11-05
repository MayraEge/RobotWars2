public class RobotPlayer implements Movable, Attackable {
    protected int x;
    protected int y;
    protected int movement;
    protected int attackStrength;
    protected int attackRange;
    protected int health;
    protected boolean tot;

    public RobotPlayer(int startX, int startY, int movement, int attackStrength, int attackRange, int health) {
        this.x = startX;
        this.y = startY;
        this.movement = movement;
        this.attackStrength = attackStrength;
        this.attackRange = attackRange;
        this.health = health;
        this.tot = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getMovement() { return movement; }
    public int getAttackStrength() { return attackStrength; }
    public int getAttackRange() { return attackRange; }
    public boolean isTot() {return tot;}

    public int getHealth() { return health; }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public void move(char direction) {
        switch (direction) {
            case 'w':
                move(-1, 0);
                break;
            case 's':
                move(1, 0);
                break;
            case 'a':
                move(0, -1);
                break;
            case 'd':
                move(0, 1);
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Richtung: " + direction);
        }
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            tot = (true);
        }
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

}