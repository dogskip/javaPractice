import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileIOTest2 {
    public static void main(String[] args) throws IOException {
        String content = "Hello, this is a test for file writing!";
        char[] charArray = content.toCharArray();

        try (Writer writer = new FileWriter("output.txt")) {
            writer.write(charArray);
            int writtenCnt = charArray.length;

            System.out.println("Written characters: ");
            for (int i = 0; i < writtenCnt; i++) {
                System.out.print(charArray[i]);
            }
            System.out.println();
            System.out.println("writtenCnt = " + writtenCnt);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}