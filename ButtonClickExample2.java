import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonClickExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Example");
        JButton button = new JButton("Open KakaoTalk");

        // 익명 내부 클래스를 사용하여 ActionListener 인터페이스 구현
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 카카오톡 실행 경로를 지정
                    String kakaoPath = "C:\\Program Files (x86)\\Kakao\\KakaoTalk\\KakaoTalk.exe";
                    Runtime.getRuntime().exec(kakaoPath);
                    System.out.println("KakaoTalk is opening...");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.add(button);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
