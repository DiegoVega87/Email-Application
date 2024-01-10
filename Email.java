import java.util.Scanner;

public class Email {

    // Attributes
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private String alternateEmail;
    private String companySuffix = "company.com";
    private  int defaultPassLength = 8;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            this.firstName = firstName;
            this.lastName = lastName;
        } else {
            System.out.println("Error: First name and last name can't be null");
        }

        // Set the department
        setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPassLength);
        System.out.println("Your password is: " + password);

        // Generate email
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

    // Set the alternate email

    // Change the password

    // Getters and Setters

}
