public interface Attackable {
    void attack(Roboter target);
    void verliereLeben(int schaden);
    boolean istTot();
    int getLeben();
}
