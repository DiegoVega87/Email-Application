import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        em1.setAlternateEmail("jacob");
        System.out.println(em1.getAlternateEmail());


    }

}