package example.decorators;

import example.AbstractBeverage;
import example.AbstractCondimentDecorator;

public class Soy extends AbstractCondimentDecorator {

    public Soy(AbstractBeverage beverage) {
        this.beverage = beverage;
        this.description = "두유";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
