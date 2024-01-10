import java.util.Scanner;

public class Email {

    // Attributes
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultMailboxCapacity;
    private String alternateEmail;
    private  int defaultPassLength;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            this.firstName = firstName;
            this.lastName = lastName;
        } else {
            System.out.println("Error: First name and last name can't be null");
        }
        defaultPassLength = 8;
        defaultMailboxCapacity = 500;

        // Set the department
        setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPassLength);
        System.out.println("Your password is: " + password);

        // Generate email
        String companySuffix = "company.com";
        email = (firstName + (".")+ lastName + "@" + (department.isEmpty() ? companySuffix : department + "."
                + companySuffix)).toLowerCase();
        System.out.println("Your email is: "+ email);

    }

    // Ask for the department
    private void setDepartment() {
        System.out.println(
                "DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code:");
        Scanner in = new Scanner(System.in);

        int deptChoice = in.nextInt();

        while (deptChoice != 1 && deptChoice != 2 && deptChoice != 3 && deptChoice != 0) {
            System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
            deptChoice = in.nextInt();
        }
        switch (deptChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                this.department = "";
                break;
        }
        in.close();
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(index);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setDefaultMailboxCapacity(int capacity){
        if(capacity > 500){
            this.defaultMailboxCapacity = capacity;
        }else{
            System.out.println("Error: Capacity cannot go under 500Mb");
        }
    }
    // Set the alternate email

    public void setAlternateEmail(String alternateEmail) {
        while (!alternateEmail.matches("^[a-z].*[0-9._]*@.[a-z]*\\.[a-z]{2,3}$")){
            System.out.println("ERROR: Invalid alternate email address.\nPlease provide a valid one");
        }
        this.alternateEmail = alternateEmail;
    }
    // Change the password
    public void setPassword(String newPassword){
        if(!newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_]).{8,}")){
            System.out.println("""
                    ERROR: Please enter a valid password with
                    At least 1 uppercase letter
                    At least 1 lowercase letter
                    At least 1 special character: !@#$%^&*_
                    At least 8 characters long
                    """);
            System.out.println("Password not changed!");
        }else {
            password = newPassword;
            System.out.println("Password changed successfully");
        }
    }
    // Getters

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }
    public int getMailboxCapacity(){
        return defaultMailboxCapacity;
    }

}
