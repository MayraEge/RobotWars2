public abstract class RobotPlayer implements Attackable, Movable {
    protected int x;
    protected int y;
    protected int movementRange;
    protected int attackStrength;
    protected int attackRange;
    protected int health;

    public RobotPlayer(int startX, int startY, int movementRange, int attackStrength, int attackRange, int health, Spielfeld spielfeld, Bewegung bewegung) {
        this.x = startX;
        this.y = startY;
        this.movementRange = movementRange;
        this.attackStrength = attackStrength;
        this.attackRange = attackRange;
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public boolean isTot() {
        return health<=0;
    }

    public int getHealth() {
        return health;
    }


    @Override
    public void move(int deltaX, int deltaY) {
        int distance = Math.abs(deltaX) + Math.abs(deltaY);
        if (distance <= movementRange) {
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
        if (distance > movementRange) {
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
