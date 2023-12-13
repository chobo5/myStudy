import behavior.fly.FlyNoWay;
import behavior.quack.Squack;
import ducks.Duck;
import ducks.RubberDuck;

public class Main {
    public static void main(String[] args) {

        Duck rubberDuck = new RubberDuck(new FlyNoWay(), new Squack());
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();

    }
}