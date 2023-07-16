package com.yustunay.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "yustunay",
            groupId = "groupId",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener received: "+ data + " 🎉" );
    }

}
