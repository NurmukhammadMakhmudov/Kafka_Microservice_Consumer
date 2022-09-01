package com.example.b_consumer;

import com.example.b_consumer.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
@EnableKafka
@SpringBootApplication
public class BConsumerApplication {

    @Autowired
    private MongoRepository mongoRepository;

    @KafkaListener(topics = "topic", containerFactory = "singleFactory")
    public void consumer(MessageModel message){
        try {
            System.out.println(message);

            mongoRepository.save(message);



        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BConsumerApplication.class, args);
    }

}
