import java.lang.reflect.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // 클래스 객체 가져오기 (forName 메소드 방식)
        Class<Person> personClass = (Class<Person>) Class.forName("Person");

        // 생성자 가져오기 - Person(String name, int age)
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class); // getConstructor 인자로 생성자의 매개변수 타입을 바인딩 해주어야 한다.

        // 가져온 생성자로 인스턴스 만들기
        Person person1 = constructor.newInstance("홍길동", 55);
        person1.getField(); // 이름 : 홍길동, 나이 : 55
    }
}
