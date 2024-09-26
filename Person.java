class Person {
    public String name; // public 필드
    private int age; // private 필드

    public static int height = 180; // static 필드

    // 이름, 나이를 입력받는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 기본 생성자
    public Person() {
    }

    public void getField() {
        System.out.printf("이름 : %s, 나이 : %d\n", name, age);
    }

    // public 메소드
    public int sum(int left, int right) {
        return left + right;
    }

    // static 메소드
    public static int staticSum(int left, int right) {
        return left + right;
    }

    // private 메소드
    private int privateSum(int left, int right) {
        return left + right;
    }
}