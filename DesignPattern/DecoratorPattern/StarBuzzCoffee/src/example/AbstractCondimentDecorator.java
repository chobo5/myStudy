package example;

public abstract class AbstractCondimentDecorator extends AbstractBeverage{
    protected AbstractBeverage beverage;

    public abstract String getDescription();
}
