import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatClientGUI {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;
    private PrintWriter out;

    public ChatClientGUI() {
        frame = new JFrame("Chat Client");
        chatArea = new JTextArea(20, 50);
        inputField = new JTextField(50);

        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);

        frame.getContentPane().add(chatScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (message != null && !message.trim().isEmpty()) {
                    out.println(message);
                    inputField.setText("");
                }
            }
        });

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void start() {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        final String message = serverMessage;
                        SwingUtilities.invokeLater(() -> chatArea.append(message + "\n"));
                    }
                } catch (IOException e) {
                    SwingUtilities.invokeLater(() -> chatArea.append("Connection to server lost.\n"));
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            chatArea.append("Unable to connect to server.\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClientGUI client = new ChatClientGUI();
        client.start();
    }
}
