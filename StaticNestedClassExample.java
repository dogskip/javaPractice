class OuterClass {
    private static String staticOuterField = "Static Outer Field";

    // 정적 내부 클래스
    static class StaticNestedClass {
        void display() {
            // 외부 클래스의 정적 멤버에 접근 가능
            System.out.println("Accessing: " + staticOuterField);
        }
    }
}

public class StaticNestedClassExample {
    public static void main(String[] args) {

        // 외부 클래스의 인스턴스 없이 정적 내부 클래스의 인스턴스 생성
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();
    }
}
