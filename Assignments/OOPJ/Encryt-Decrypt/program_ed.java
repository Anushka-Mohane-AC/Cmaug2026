import java.io.*;
public class program_ed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch;

        do {
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            System.out.println("3. Exit");

            ch = Integer.parseInt(br.readLine());

            switch (ch) {
                case 1:
                    System.out.print("Enter input file path: ");
                    String inputFile = br.readLine();
                    System.out.print("Enter encrypted file path: ");
                    String encryptedFile = br.readLine();
                    Encrypt.encryptp(inputFile, encryptedFile);
                    break;

                case 2:
                    System.out.print("Enter encrypted file path: ");
                    String encFile = br.readLine();
                    System.out.print("Enter decrypt file path: ");
                    String decryptedFile = br.readLine();
                    decrypt.decryptp(encFile, decryptedFile);
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (ch != 3);
    }

}

//    /Users/anushkamohane/Desktop/JavaUpskill/Intellij/OOPJ/src/pqr - input file path
//    /Users/anushkamohane/Desktop/JavaUpskill/Intellij/OOPJ/src/abc - encrypt file path
//    /Users/anushkamohane/Desktop/JavaUpskill/Intellij/OOPJ/src/decryptfile - decrypt file path