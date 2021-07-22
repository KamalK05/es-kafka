package com.in.eskafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaStreams {
    String OUTPUT_ES_KAFKA = "es-kafka-out";

    String INPUT_ES_KAFKA = "es-kafka-in";

    @Output(OUTPUT_ES_KAFKA)
    SubscribableChannel esKafkaOutChannel();

    @Input(INPUT_ES_KAFKA)
    SubscribableChannel esKafkaInChannel();
}
