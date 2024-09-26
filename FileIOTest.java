import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileIOTest {
    public static void main(String[] args) throws Exception {

        char[] charBuffer = new char[100];

        Reader reader = new FileReader("test.txt");

        int readCnt = reader.read(charBuffer);

        //이렇게 돌면 100까지 다돔
        /*for(int cnt : charBuffer) {
            System.out.println((char)cnt);
        }*/

        for(int i =0; i < readCnt; i++) {
            System.out.println(charBuffer[i]);
        }

        System.out.println();
        System.out.println("readCnt = " + readCnt);
        reader.close();
    }
}
