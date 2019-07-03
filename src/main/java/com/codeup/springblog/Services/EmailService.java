package com.codeup.springblog.Services;

import com.codeup.springblog.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;
    private MimeMessage session;

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try {
            this.emailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

//    public void html(String[] args, String messageBody, MimeBodyPart message) throws MessagingException, IOException {
//    Multipart multipart = new MimeMultipart("related");
//
//    MimeBodyPart htmlPart = new MimeBodyPart();
//    //add reference to your image to the HTML body <img src="cid:some-image-cid" alt="img" />
//        htmlPart.setText(messageBody, "utf-8", "html");
//        multipart.addBodyPart(htmlPart);
//
//    MimeBodyPart imgPart = new MimeBodyPart();
//    // imageFile is the file containing the image
//        imgPart.attachFile("/Users/mykalclinard/IdeaProjects/springblog/src/main/resources/static/img/bgBlue.jpeg");
//    // or, if the image is in a byte array in memory, use
//    // imgPart.setDataHandler(new DataHandler(
//    //      new ByteArrayDataSource(bytes, "image/whatever")));
//
//        imgPart.setContentID("<some-image-cid>");
//                multipart.addBodyPart(imgPart);
//
//        message.setContent(multipart);
//    }


//    public void htmlSend(Post post, String subject, String info) {
//        try {
//            MimeMessage msg2 = new MimeMessage();
//            msg2.setFrom(new InternetAddress(from));
//            msg2.setRecipients(MimeMessage.RecipientType.TO,
//                    InternetAddress.parse(post.getUser().getEmail()));
//            msg2.setSubject(subject);
//            msg2.setContentLanguage(new String[]{info});
//            //sending message
//            Transport.send(msg2);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}
