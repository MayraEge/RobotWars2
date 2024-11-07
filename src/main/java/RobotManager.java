import java.util.List;
import java.util.ArrayList;

public class RobotManager  {
    private List <Roboter> robots;
    private Spielfeld spielfeld;

    public RobotManager (Spielfeld spielfeld) {
        this.robots = new ArrayList<>();
        this.spielfeld = spielfeld;
    }

    public void addRobot(Roboter robot){
        robots.add(robot);
        spielfeld.addRoboter(robot);
    }

    public void removeRobot(Roboter robot) {
        robots.remove(robot);
        spielfeld.addRoboter(robot);
    }

    public void moveRobot (Roboter robot, char direction){
        robot.move(direction);
    }

    public void robotAttack(Roboter angreifer, Roboter target){
        angreifer.attack(target);
    }

    public List<Roboter> getRobots(){
        return robots;
    }

    public Spielfeld getSpielfeld(){
        return spielfeld;
    }
}
