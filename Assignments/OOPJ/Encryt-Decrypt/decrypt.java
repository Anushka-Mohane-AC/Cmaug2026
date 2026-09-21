import java.io.*;
public class decrypt {
    static void decryptp(String sf, String tf) throws IOException {
        FileReader r = new FileReader(sf);
        FileWriter w = new FileWriter(tf);

        int data;
        while ((data = r.read()) != -1) {
            int decrypted = data / 11;
            w.write(decrypted);
        }

        r.close();
        w.close();

        System.out.println("Decryption complete! Saved to: " + tf);
    }
}
