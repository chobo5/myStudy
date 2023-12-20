package example.coffee;

import example.AbstractBeverage;

public class HouseBlend extends AbstractBeverage {

    public HouseBlend() {
        this.description = "하우스블렌드";
    }
    @Override
    public double cost() {
        return 0.89;
    }


}
