package io.github.osmanfurkan115.emailservice.config

import io.github.osmanfurkan115.emailservice.model.EmailProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Configuration
@EnableConfigurationProperties(EmailProperties::class)
class EmailConfig(private val emailProperties: EmailProperties) {

    @Bean
    fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = emailProperties.host
        mailSender.port = emailProperties.port
        mailSender.username = emailProperties.username
        mailSender.password = emailProperties.password
        val props: Properties = mailSender.javaMailProperties
        props["mail.transport.protocol"] = emailProperties.protocol
        props["mail.smtp.auth"] = emailProperties.auth
        props["mail.smtp.starttls.enable"] = emailProperties.starttlsEnable
        props["mail.debug"] = emailProperties.debug
        return mailSender
    }
}