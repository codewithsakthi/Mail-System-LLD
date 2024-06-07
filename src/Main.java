import email.Mail;
import email.MailService;
import user.UserService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        MailService mailService = new MailService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    signUp(userService, scanner);
                    break;
                case 2:
                    String currentUserEmail = signIn(userService, scanner);
                    if (currentUserEmail != null) {
                        userMenu(mailService, scanner, currentUserEmail);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void signUp(UserService userService, Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (userService.signUp(email, password, name)) {
            System.out.println("Sign up successful!");
        } else {
            System.out.println("Email already exists. Please try again.");
        }
    }

    private static String signIn(UserService userService, Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.signIn(email, password)) {
            System.out.println("Sign in successful!");
            return email;
        } else {
            System.out.println("Invalid email or password. Please try again.");
            return null;
        }
    }

    private static void userMenu(MailService mailService, Scanner scanner, String currentUserEmail) {
        while (true) {
            System.out.println("\n1. Inbox");
            System.out.println("2. Compose Mail");
            System.out.println("3. Unread Mails");
            System.out.println("4. Outbox");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayInbox(mailService, currentUserEmail);
                    break;
                case 2:
                    composeMail(mailService, scanner, currentUserEmail);
                    break;
                case 3:
                    displayUnreadMails(mailService, currentUserEmail);
                    break;
                case 4:
                    displayOutbox(mailService, currentUserEmail);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayInbox(MailService mailService, String email) {
        List<Mail> inbox = mailService.getInbox(email);
        System.out.println("Inbox:");
        for (Mail mail : inbox) {
            System.out.println(mail.getSender());
            System.out.println(mail.getTimestamp());
            System.out.println(mail.getSubject());
            System.out.println(mail.getBody());
            System.out.println("_____________________________");

        }
    }

    private static void composeMail(MailService mailService, Scanner scanner, String sender) {
        System.out.print("Enter recipient email: ");
        String recipient = scanner.nextLine();
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter body: ");
        String body = scanner.nextLine();

        mailService.composeMail(sender, recipient, subject, body);
        System.out.println("Mail sent successfully!");
    }

    private static void displayUnreadMails(MailService mailService, String email) {
        List<Mail> unreadMails = mailService.getUnreadMails(email);
        System.out.println("Unread Mails:");
        for (Mail mail : unreadMails) {
            System.out.println(mail.getSender());
            System.out.println(mail.getTimestamp());
            System.out.println(mail.getSubject());
            System.out.println(mail.getBody());
            System.out.println("_____________________________");

        }
    }

    private static void displayOutbox(MailService mailService, String email) {
        List<Mail> outbox = mailService.getOutbox(email);
        System.out.println("Outbox:");
        for (Mail mail : outbox) {
            System.out.println("To :"+mail.getRecipient());
            System.out.println("Time :"+mail.getTimestamp());
            System.out.println("Subject :"+mail.getSubject());
            System.out.println("Body :"+mail.getBody());
            System.out.println("_____________________________");
        }
    }
}
