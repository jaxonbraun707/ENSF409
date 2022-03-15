import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        
        String myStr1 = "Magpie";
        String myStr2 = "Magpie";
        String myStr3 = new String("Magpie");
        String myStr4 = new String("Magpie");
        if (myStr4 == myStr2) {
            System.out.println("True");
        }
        else {
            System.out.println("false");
        }

        
    }
}