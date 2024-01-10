import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailApp {

    public static void main(String[] args) {
        //Email em1 = new Email("John", "Smith");

        String pattern1 = "^[a-z].*[0-9._]*@.[a-z]*\\.[a-z]{2,3}$";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher("ab.c@me.gov");
        System.out.println(matcher.find());

        String inputPassword = "d712013v!";
        System.out.println(inputPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_]).{8,}"));
    }

}