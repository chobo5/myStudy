import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    List<String> toppings = new ArrayList<>();
    abstract void prepare();

    void bake() {
        System.out.println("175도에서 25분간 굽기");
    }

    void cut() {
        System.out.println("피자 8등분하기");
    }

    void box() {
        System.out.println("상자에 피자담기");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {

    }
}
