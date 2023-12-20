package example.decorators;

import example.AbstractBeverage;
import example.AbstractCondimentDecorator;


public class WhipingCream extends AbstractCondimentDecorator {
    public WhipingCream(AbstractBeverage beverage) {
        this.beverage = beverage;
        this.description = "휘핑크림";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.description;
    }
}
