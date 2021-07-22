package com.in.eskafka;

import com.in.eskafka.stream.KafkaStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(KafkaStreams.class)
@SpringBootApplication
public class EsKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsKafkaApplication.class, args);
	}

}
