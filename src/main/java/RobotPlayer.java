public abstract class RobotPlayer extends Angriff implements Movable {
    protected int x;
    protected int y;
    protected int movement;
    protected int attackStrength;
    protected int attackRange;
    protected int health;
    protected boolean tot;

    public RobotPlayer(int startX, int startY, int movement, int attackStrength, int attackRange, int health, Spielfeld spielfeld, Bewegung bewegung) {
        super(spielfeld, bewegung);
        this.x = startX;
        this.y = startY;
        this.movement = movement;
        this.attackStrength = attackStrength;
        this.attackRange = attackRange;
        this.health = health;
        this.tot = false;
        this.bewegung = new Bewegung(spielfeld);
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
        int distance = Math.abs(deltaX) + Math.abs(deltaY);
        if (distance <= movement) {
            this.x += deltaX;
            this.y += deltaY;
            System.out.println("Moved to(" + x + ", " + y + ")");
        } else {
            System.out.println("Bewegungsgrenze erreicht! ");
        }

    }
    @Override
    public void move(char direction) {
        int originalX = x;
        int originalY = y;

        bewegung.moveRoboter((Roboter) this, direction);

        int deltaX = Math.abs(x - originalX);
        int deltaY = Math.abs(y - originalY);
        int distance = deltaX + deltaY;

//macht bewegung rueckgaengig falls limit erreicht
        if (distance > movement){
            this.x = originalX;
            this.y = originalY;
            System.out.println("Bewegungsgrenze erreicht! Bewegung wurde zurückgesetzt. ");

        }
    }


    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            tot = (true);
        }
        System.out.println("Schaden: " + damage + " Restliche Gesundheit: " + health);
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public abstract void attack(Roboter target);
}
