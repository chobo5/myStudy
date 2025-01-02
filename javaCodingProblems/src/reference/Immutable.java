package reference;

public class Immutable {
    public static void prove(String str) {
        System.out.println(str + "'s hashcode is" + str.hashCode());
        str = "new String";
        System.out.println("Assign new String to str");
        System.out.println(str + "'s hashcode is" + str.hashCode());

    }

    final class Price {
        private final int value;

        public Price(int value) {
            if (value <= 0) {
                throw new IllegalArgumentException("Price must be positive");
            }
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Immutable.prove("Original");
        

    }


}
