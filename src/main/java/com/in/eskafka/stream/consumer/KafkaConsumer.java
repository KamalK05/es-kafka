package com.in.eskafka.stream.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.eskafka.stream.KafkaStreams;
import com.in.eskafka.stream.entities.AbstractKafkaEvent;
import com.in.eskafka.stream.entities.OrganizationEvent;
import com.in.eskafka.util.ElasticSearchWriteUtil;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    ElasticSearchWriteUtil elasticSearchWriteUtil;

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @StreamListener(KafkaStreams.INPUT_ES_KAFKA)
    public void consume(Message<AbstractKafkaEvent<OrganizationEvent>> message) {
        logger.info("data='{}'", message);
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        logger.info("KafkaConsumer: consume: acknowledgment: {}", acknowledgment);
        if (acknowledgment != null) {
            AbstractKafkaEvent<OrganizationEvent> abstractKafkaEvent = message.getPayload();
            if (Objects.nonNull(abstractKafkaEvent.getData())) {
                OrganizationEvent organizationEvent = objectMapper.convertValue(abstractKafkaEvent.getData(), OrganizationEvent.class);
                Boolean flag = elasticSearchWriteUtil.writeDataToElasticSearch(organizationEvent);
                if (flag) {
                    logger.info("KafkaConsumer: consume: Acknowledging Kafka Event {}", abstractKafkaEvent);
                    acknowledgment.acknowledge();
                } else {
                    logger.error("KafkaConsumer: consume: Error acknowledging kafka event");
                }
            }
        }
    }
}
