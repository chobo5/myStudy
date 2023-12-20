package example.decorators;

import example.AbstractBeverage;
import example.AbstractCondimentDecorator;

public class Mocha extends AbstractCondimentDecorator {

    public Mocha(AbstractBeverage beverage) {
        this.description = "모카";
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
