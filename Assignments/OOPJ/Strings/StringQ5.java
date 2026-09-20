public class StringQ5 {
    public static void main(String[] args) {
        String main = "The quick brown fox jumps over the lazy dog.";
        String changed = main.replaceAll("fox", "cat");

        System.out.println("Original string: " + main);
        System.out.println("New String: " + changed);
    }
}
