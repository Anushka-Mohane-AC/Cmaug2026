public class StringQ7 {
    public static void main(String[] args) {
        String t = "The quick brown fox jumps";
        System.out.println("The given string is: " + t);

        String r = "";
        for (int i = t.length() - 1; i >= 0; i--) {
            r += t.charAt(i);
        }

        System.out.println("The string in reverse order is:" + r);
    }
}
