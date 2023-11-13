package main.org.example.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class EmailUtils {
    private static final String FROM = "Chaplain04@gmail.com";
    private static final String PASSWORD = "iwsk azez sivj cwus";
    private static final Properties PROPS = new Properties();

    static {
        PROPS.put("mail.smtp.host", "smtp.gmail.com");
        PROPS.put("mail.smtp.port", "587");//465
        PROPS.put("mail.smtp.auth", "true");
        PROPS.put("mail.smtp.starttls.enable", "true"); //TLS
    }

    private static Session getSession() {
        return Session.getInstance(PROPS, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASSWORD);
            }
        });
    }

    public static void send(final String to, final String subject, final String msg) {
        send(to, subject, msg, null);
    }

    public static void send(final String to, final String subject, final String msg, final String attachmentPathname) {
        HashSet<String> toSet = new HashSet<>();
        toSet.add(to);
        send(toSet, null, null, subject, msg, attachmentPathname);
    }


    public static void send(final Set<String> to, final Set<String> cc, final Set<String> bcc,
                            final String subject, final String msg, final String attachmentPathname) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(FROM));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(String.join(", ", to))
            );
            if (cc != null && cc.size() > 0)
                message.setRecipients(
                        Message.RecipientType.CC,
                        InternetAddress.parse(String.join(", ", cc))
                );
            if (bcc != null && bcc.size() > 0)
                message.setRecipients(
                        Message.RecipientType.BCC,
                        InternetAddress.parse(String.join(", ", bcc))
                );

            message.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(msg, "text/html");

            messageBodyPart.setText(msg);
            MimeBodyPart ap = new MimeBodyPart();
//            if (attachmentPathname != null) {
//                ap.attachFile(new File(attachmentPathname));
//
//            }
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            if (attachmentPathname != null)
                multipart.addBodyPart(ap);
            message.setContent(multipart);
            message.setText(msg);
            message.setContent(msg, "text/html");


            Transport.send(message);
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        EmailUtils.send("Chaplain04@gmail.com", "Subject", EncryptDecryptUtils.encrypt("dtyp qmsr ykgf dwjt"));
    }
}
