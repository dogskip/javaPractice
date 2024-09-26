public class EnumExample {
    public static void main(String[] args) {
        // valueOf() 메서드를 사용하여 문자열을 열거형 상수로 변환합니다.
        String dayName = "FRIDAY";
        Day day = Day.valueOf(dayName);
        String day2 =  day.toString();
        System.out.println("The day is " + day);
        System.out.println("The day is " + day2);
    }
}