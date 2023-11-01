package br.com.mail.mtmailsender.infrastructure.producers;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendMailQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailQueue.class);

    @Value("${spring.activemq.send-mail-queue}")
    private String destination;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public SendMailQueue(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        try {
            LOGGER.info("Sending message to queue: {}", message);
            jmsTemplate.convertAndSend(destination, message);
        } catch (Exception e) {
            LOGGER.error("Error sending message to queue: {}", e.getMessage());
        }
    }
}
