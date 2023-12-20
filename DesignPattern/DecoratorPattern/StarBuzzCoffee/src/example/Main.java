package example;

import example.coffee.DarkRoast;
import example.decorators.Mocha;
import example.decorators.WhipingCream;

public class Main {
    public static void main(String[] args) {

        AbstractBeverage darkRoast = new Mocha(new WhipingCream(new DarkRoast()));


        System.out.println(darkRoast.cost());
        System.out.println(darkRoast.getDescription());
    }
}