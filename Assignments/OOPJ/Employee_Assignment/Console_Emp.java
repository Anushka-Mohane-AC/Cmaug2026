import java.io.*;
public class Console_Emp {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static String getString() {
            try {
                return br.readLine();
            } catch (Exception e) {
                return "";
            }
        }

        public static int getInt() {
            try {
                return Integer.parseInt(br.readLine());
            } catch (Exception e) {
                return 0;
            }
        }

        public static float getFloat() {
            try {
                return Float.parseFloat(br.readLine());
            } catch (Exception e) {
                return 0.0f;
            }
        }
    }

