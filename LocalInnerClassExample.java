class OuterClass2 {
    void someMethod() {
        // 지역 내부 클래스 정의
        class LocalInnerClass {
            static void  display() {
                System.out.println("Local Inner Class Method");
            }
        }

        // 지역 내부 클래스의 인스턴스 생성 및 메서드 호출
        LocalInnerClass.display();
    }
}

public class LocalInnerClassExample {
    public static void main(String[] args) {
        OuterClass2 outer = new OuterClass2();
        outer.someMethod();
    }
}
