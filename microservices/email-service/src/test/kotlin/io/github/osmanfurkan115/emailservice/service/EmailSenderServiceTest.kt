package io.github.osmanfurkan115.emailservice.service

import io.github.osmanfurkan115.emailservice.model.SendEmailRequest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.mock
import org.springframework.mail.javamail.JavaMailSender

internal class EmailSenderServiceTest {
    private lateinit var emailSenderService: EmailSenderService

    @BeforeEach
    fun setUp() {
        val javaMailSender = mock(JavaMailSender::class.java)
        emailSenderService = EmailSenderService(javaMailSender)
    }

    @Test
    fun sendEmail() {
        assertDoesNotThrow { emailSenderService.sendEmail(SendEmailRequest("osmanfurkan115@gmail.com",
        "Test", "Test")) }
    }
}