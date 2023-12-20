package example.coffee;

import example.AbstractBeverage;

public class DarkRoast extends AbstractBeverage {

    public DarkRoast() {
        this.description = "다크로스트";
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
