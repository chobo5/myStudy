package example.coffee;

import example.AbstractBeverage;

public class Espresso extends AbstractBeverage {

    public Espresso() {
        this.description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
