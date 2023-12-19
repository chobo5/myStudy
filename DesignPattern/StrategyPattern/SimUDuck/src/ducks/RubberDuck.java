package ducks;

import behavior.fly.FlyBehavior;
import behavior.fly.FlyNoWay;
import behavior.quack.Quack;
import behavior.quack.QuackBehavior;
import behavior.quack.Squack;

public class RubberDuck extends Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    @Override
    public void display() {
        System.out.println("고무 오리입니디.");
    }

    @Override
    public void performFly() {
        flyBehavior.fly();
    }

    @Override
    public void performQuack() {
        quackBehavior.quack();
    }
}
