public class StringChange {
    public static void main(String[] args) {
        String s = "Hello Welt!";
        char[] ca = new char[s.length()]; // Redundant, könnte auch direkt mit s initialisiert werden.
        ca = s.toCharArray();
        ca[1] = 'a';

        for (char c : ca){
            System.out.println(c);
        }

        String s2 = new String(ca);
        System.out.println(s2);
        
    }
}
