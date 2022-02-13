package io.github.osmanfurkan115.emailservice.service

import io.github.osmanfurkan115.emailservice.model.SendEmailRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailSender(private val emailSender: JavaMailSender) {
    suspend fun sendEmail(emailRequest: SendEmailRequest) {
        withContext(Dispatchers.IO) {
            val message = SimpleMailMessage()
            message.setSubject(emailRequest.subject)
            message.setText(emailRequest.message)
            message.setTo(emailRequest.email)

            emailSender.send(message)
        }
    }
}