package com.in.eskafka.stream.producer;

import com.in.eskafka.stream.KafkaStreams;
import com.in.eskafka.stream.entities.AbstractKafkaEvent;
import com.in.eskafka.stream.entities.EventHeader;
import com.in.eskafka.stream.entities.OrganizationEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {

    private static final String VERSION_1_0 = "1.0";
    private static final String PARTITION_KEY = "partitionKey";
    private static final EventHeader DEFAULT_EVENT_HEADER = new EventHeader().setVersion(VERSION_1_0);

    private final KafkaStreams kafkaStreams;

    @Async("asyncKafkaProducerTaskExecutor")
    public void sendOrganizationInformation(OrganizationEvent organizationEvent) {
        log.info("KafkaProducer: sendOrganizationInformation: producing message for OrgUniqueId: {}", organizationEvent.getUniqueId());
        // generate message for kafka producer
        AbstractKafkaEvent<OrganizationEvent> abstractEventMessage = new AbstractKafkaEvent<>();
        abstractEventMessage.setHeader(DEFAULT_EVENT_HEADER);
        abstractEventMessage.setData(organizationEvent);
        // sending kafka message
        SubscribableChannel releaseOutChannel = kafkaStreams.esKafkaOutChannel();
        boolean sent = releaseOutChannel.send(MessageBuilder
                .withPayload(abstractEventMessage)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader(PARTITION_KEY, organizationEvent.getUniqueId())
                .build());
        log.info("KafkaProducer: sendOrganizationInformation: sent status : {}", sent);
    }
}