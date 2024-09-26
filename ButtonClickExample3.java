import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonClickExample3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Example");
        JButton button = new JButton("Open Text File");

        // 익명 내부 클래스를 사용하여 ActionListener 인터페이스 구현
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 메모장으로 텍스트 파일 열기
                    String filePath = "C:\\쿼리예상.txt";
                    Runtime.getRuntime().exec(new String[]{"notepad.exe", filePath});
                    System.out.println("Text file is opening...");
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
