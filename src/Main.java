public class Main {

    public static void main(String[] args) {
        String s = "test.jpeg";
        String[] s1 = s.split(".");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        //System.out.println("Hello World!");
    }
}
