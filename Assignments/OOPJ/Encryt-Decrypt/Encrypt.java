import java.io.*;
public class Encrypt {
    static void encryptp(String sf, String tf) throws IOException {
        FileReader r = new FileReader(sf);
        FileWriter w = new FileWriter(tf);

        int data;
        while ((data = r.read()) != -1) {
            int encrypted = data * 11;
            w.write(encrypted);
        }

        r.close();
        w.close();

        System.out.println("Encryption complete! Saved to: " + tf);
    }
}
