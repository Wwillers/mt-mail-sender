package br.com.mail.mtmailsender.infrastructure.apis;

import br.com.mail.mtmailsender.infrastructure.producers.SendMailQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailController.class);

    private final SendMailQueue sendMailQueue;

    @Autowired
    public SendMailController(SendMailQueue sendMailQueue) {
        this.sendMailQueue = sendMailQueue;
    }

    @PostMapping("/send-mail")
    public void sendMail() {
        LOGGER.info("Sending message to queue");
        sendMailQueue.send("Hello World");
    }
}
