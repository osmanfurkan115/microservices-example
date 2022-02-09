package io.github.osmanfurkan115.emailservice.service

import io.github.osmanfurkan115.emailservice.model.SendEmailRequest
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailSenderService(private val emailSender: JavaMailSender) {
    fun sendEmail(emailRequest: SendEmailRequest) {
        val message = SimpleMailMessage()

        message.setSubject(emailRequest.subject)
        message.setText(emailRequest.message)
        message.setTo(emailRequest.email)

        emailSender.send(message)
    }
}