package br.com.mail.mtmailsender.infrastructure.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SendMailQueueConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailQueueConsumer.class);

    @JmsListener(destination = "${spring.activemq.send-mail-queue}")
    public void consume(String message) {
        LOGGER.info("Consuming message from queue: {}", message);
    }
}
