public class StringQ4 {
    public static void main(String[] args) {
        String t = "The quick brown fox jumps over the lazy dog.".toLowerCase();

        System.out.println("a  b c  d e  f  g h i  j");
        System.out.println("=========================");
        for (char ch = 'a'; ch <= 'j'; ch++) {
            System.out.print(t.indexOf(ch) + " ");
        }
        System.out.println(" ");

        System.out.println("k  l  m  n  o  p q  r  s  t");
        System.out.println("===========================");
        for (char ch = 'k'; ch <= 't'; ch++) {
            System.out.print(t.indexOf(ch) + " ");
        }
        System.out.println(" ");

        System.out.println("u  v  w  x  y  z");
        System.out.println("===========================");
        for (char ch = 'u'; ch <= 'z'; ch++) {
            System.out.print(t.indexOf(ch) + " ");
        }
    }
}
