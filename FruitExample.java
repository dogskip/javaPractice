enum Fruit {
    APPLE("Red", 1000),
    BANANA("Yellow", 700),
    GRAPE("Purple", 2000),
    BLUEBERRY("Blue", 2500);

    private final String color;
    private final int price;

    Fruit(String color, int price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}

public class FruitExample {
    public static void main(String[] args) {
        Fruit myFruit = Fruit.BANANA;

        System.out.println("Selected fruit: " + myFruit);
        System.out.println("Color: " + myFruit.getColor());
        System.out.println("Price: " + myFruit.getPrice() + " won");

        System.out.println("\nAll fruits:");
        for (Fruit fruit : Fruit.values()) {
            System.out.println(fruit + " - Color: " + fruit.getColor() + ", Price: " + fruit.getPrice() + " won");
        }

        // switch 문 사용 예제
        System.out.println("\nFruit recommendation:");
        switch (myFruit) {
            case APPLE:
                System.out.println("An apple a day keeps the doctor away!");
                break;
            case BANANA:
                System.out.println("Bananas are great for potassium!");
                break;
            case GRAPE:
                System.out.println("Grapes are perfect for snacking!");
                break;
            case BLUEBERRY:
                System.out.println("Blueberries are full of antioxidants!");
                break;
        }
    }
}
