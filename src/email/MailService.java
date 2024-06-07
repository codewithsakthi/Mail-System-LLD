package email;

import java.util.*;
public class MailService {
    private List<Mail> mails = new ArrayList<>();

    public void composeMail(String sender, String recipient, String subject, String body) {
        String mailId = generateMailId();
        Mail mail = new Mail(mailId, sender, recipient, subject, body);
        mails.add(mail);
    }

    private String generateMailId() {
        return "mail" + (mails.size() + 1);
    }

    public List<Mail> getUnreadMails(String recipient) {
        List<Mail> unreadMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getRecipient().equals(recipient) && !mail.isRead()) {
                unreadMails.add(mail);
            }
        }
        return unreadMails;
    }

    public List<Mail> getInbox(String recipient) {
        List<Mail> inbox = new ArrayList<>();
        for (Mail mail : mails) {
            mail.setRead(true);
            if (mail.getRecipient().equals(recipient)) {
                inbox.add(mail);
            }
        }
        return inbox;
    }

    public List<Mail> getOutbox(String sender) {
        List<Mail> outbox = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getSender().equals(sender)) {
                outbox.add(mail);
            }
        }
        return outbox;
    }

}
