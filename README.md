Gmail-like Application
Overview
This is a simple command-line application simulating basic email functionalities similar to Gmail. It allows users to sign up, sign in, compose emails, view their inbox, check unread emails, view the outbox, and log out.

Features
Sign Up: Create a new user account.
Sign In: Log in with an existing user account.
Compose Mail: Send an email to another user.
Inbox: View all received emails.
Unread Mails: View all unread received emails.
Outbox: View all sent emails.
Logout: Log out of the current session.
Classes
User Class
Represents a user in the system.

UserService Class
Handles user-related operations such as sign-up and sign-in.

Mail Class
Represents an email in the system.

MailService Class
Handles mail-related operations such as composing and retrieving emails.

Main Class
Provides the main entry point for the application and handles user interaction.

Usage
Clone the repository:

bash
Copy code
git clone https://github.com/codewithsakthi/Mail-System-LLD.git
cd Mail-System-LLD
Compile the code: javac Main.java
Run the application: java Main
Follow the on-screen prompts to sign up, sign in, and use the email functionalities.
Example
plaintext
Copy code
1. Sign Up
2. Sign In
3. Exit
Choose an option: 1
Enter email: user@example.com
Enter password: password123
Enter name: John Doe
Sign up successful!

1. Sign Up
2. Sign In
3. Exit
Choose an option: 2
Enter email: user@example.com
Enter password: password123
Sign in successful!

1. Inbox
2. Compose Mail
3. Unread Mails
4. Outbox
5. Logout
Choose an option: 2
Enter recipient email: friend@example.com
Enter subject: Hello
Enter body: Hi there!
Mail sent successfully!

1. Inbox
2. Compose Mail
3. Unread Mails
4. Outbox
5. Logout
Choose an option: 5
Logging out...
License
This project is licensed under the MIT License.
