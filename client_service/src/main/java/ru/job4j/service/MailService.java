package ru.job4j.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Message;

@Service
@Slf4j
public class MailService {

    @KafkaListener(topics = {"${spring.kafka.default-topic}"})
    public void consume(Message message) {
        log.info("consumed => {}", message);
    }
}