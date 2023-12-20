package example.coffee;

import example.AbstractBeverage;

public class Decaffeine extends AbstractBeverage {

    Decaffeine() {
        this.description = "디카페인";
    }

    @Override
    public double cost() {
        return 1.05;
    }

}
