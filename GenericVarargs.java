public class GenericVarargs {
    public static <T> void printElements(T... elements) {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printElements(1, 2, 3);
        printElements("Hello", "World");
        printElements(1.0, 2.5, 3.7,"dd");
    }
}
