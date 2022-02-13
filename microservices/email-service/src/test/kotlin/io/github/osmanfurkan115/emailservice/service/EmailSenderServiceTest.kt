package io.github.osmanfurkan115.emailservice.service

import io.github.osmanfurkan115.emailservice.model.SendEmailRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.mock
import org.springframework.mail.javamail.JavaMailSender

internal class EmailSenderServiceTest {
    private lateinit var emailSender: EmailSender

    @BeforeEach
    fun setUp() {
        val javaMailSender = mock(JavaMailSender::class.java)
        emailSender = EmailSender(javaMailSender)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun sendEmail() {
        assertDoesNotThrow {
            runBlocking {
                emailSender.sendEmail(SendEmailRequest("osmanfurkan115@gmail.com", "Test Mail", "Test Message"))

            }
        }
    }
}