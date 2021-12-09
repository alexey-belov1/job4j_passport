package ru.job4j.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Message;

@Service
@Slf4j
public class PassportScheduledTasks {

    @Autowired
    private KafkaTemplate<Integer, Message> kafkaTemplate;

    @Autowired
    private PassportService passportService;

    @Value("${spring.kafka.default-topic}")
    private String topic;

    @Scheduled(fixedDelayString = "${scheduling.passport.interval}")
    public void notifyExpired() {
        passportService.findUnavailable()
                .forEach(passport -> kafkaTemplate.send(topic, new Message("Expired passport: " + passport.getSeries() + " " + passport.getNumber())));
    }
}