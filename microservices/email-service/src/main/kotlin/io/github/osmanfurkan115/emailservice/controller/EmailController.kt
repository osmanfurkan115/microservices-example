package io.github.osmanfurkan115.emailservice.controller

import io.github.osmanfurkan115.emailservice.model.SendEmailRequest
import io.github.osmanfurkan115.emailservice.service.EmailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/email"])
class EmailController(private val emailSender: EmailSender) {

    @PostMapping
    suspend fun sendEmail(@RequestBody sendEmailRequest: SendEmailRequest) {
        emailSender.sendEmail(sendEmailRequest)
    }
}