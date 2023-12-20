package example;

public abstract class AbstractBeverage {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
