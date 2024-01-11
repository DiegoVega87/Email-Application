
public class EmailApp {

    public static void main(String[] args) {
        Email email = new Email("John", "Smith");
        System.out.println(email.showInfo());

        System.out.println("Alternate email:"+email.getAlternateEmail()+"\n");
        email.setAlternateEmail("");
        email.setAlternateEmail("jhonsmith@me.com");
        System.out.println("Alternate Email: " + email.getAlternateEmail() +"\n");
        email.setPassword("asfgassdg");
        email.setPassword(("A123bbA_"));
        email.setDefaultMailboxCapacity(100);
        email.setDefaultMailboxCapacity(600);
        System.out.println(email.getMailboxCapacity());
        System.out.println(email.getEmail());
    }

}