public class test{
    public static void main(String[] args) {
        String s = "My name is Carrol";

        System.out.println("string is " + s);
        System.out.println("the length of string is " + s.length());
        System.out.println("the first char is " + s.substring(0, 1));
        System.out.println("the last char is " + s.substring(s.length() - 1));
        s.trim();
        System.out.println("the first phrase is " + s.substring(0, s.indexOf(" ")));
    }
}