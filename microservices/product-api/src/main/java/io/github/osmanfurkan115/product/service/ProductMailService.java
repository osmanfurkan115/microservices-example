package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.SendEmailRequest;
import org.springframework.lang.Nullable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class ProductMailService {
    private final JavaMailSender javaMailSender;

    public ProductMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendProductPurchaseMail(String email, Product product) throws MessagingException { //TODO: add the buyer and product
        sendMailMultipart(new SendEmailRequest(email, "Product Purchase",
                "You purchased a product named " + product.getProductName()), null);
    }

    private void sendMailMultipart(SendEmailRequest emailRequest, @Nullable File file) throws MessagingException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(emailRequest.getEmail());
        mimeMessageHelper.setTo(emailRequest.getEmail());
        mimeMessageHelper.setSubject(emailRequest.getSubject());
        mimeMessageHelper.setText(emailRequest.getMessage());

        if(file != null) mimeMessageHelper.addAttachment(file.getName(), file);

        javaMailSender.send(mimeMessage);
    }
}
