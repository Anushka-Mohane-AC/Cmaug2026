public class StringQ2 {
    public static void main(String[] args) {
        String s1 = "This is Exercise 1";
        String s2 = "This is Exercise 2";

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);

        int result = s1.compareTo(s2);
        if (result < 0) {
            System.out.println("\"" + s1 + "\" is less than \"" + s2 + "\"");
        } else if (result > 0) {
            System.out.println("\"" + s1 + "\" is greater than \"" + s2 + "\"");
        } else {
            System.out.println("\"" + s1 + "\" is equal to \"" + s2 + "\"");
        }
    }
}
