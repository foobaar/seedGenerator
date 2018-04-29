package com.demo.seedGenerator.service;

import com.demo.seedGenerator.config.KafkaSeedProducerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SeedProducer {
    private static final Logger log = LoggerFactory.getLogger(SeedProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaSeedProducerProperties properties;

    @Autowired
    public SeedProducer(KafkaTemplate template, KafkaSeedProducerProperties properties) {
        this.kafkaTemplate = template;
        this.properties = properties;
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void seed() {
        Random rand = new Random();
        int randomSeed = rand.nextInt(98) + 1;
        kafkaTemplate.send(properties.getTopic(), String.valueOf(randomSeed));
        log.info("seeded with {}", randomSeed);
    }
}
