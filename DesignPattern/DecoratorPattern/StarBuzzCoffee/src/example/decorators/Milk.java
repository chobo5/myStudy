package example.decorators;

import example.AbstractBeverage;
import example.AbstractCondimentDecorator;

public class Milk extends AbstractCondimentDecorator {

    public Milk(AbstractBeverage beverage) {
        this.description = "우유";
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
