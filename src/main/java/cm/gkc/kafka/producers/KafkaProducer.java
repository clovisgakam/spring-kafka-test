package cm.gkc.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by gkc on 07/05/17.
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Integer,String> kafkaTemplate ;



    @Scheduled(initialDelay = 1000*60,fixedDelay = 1000*30)
    public void scheduleMessage(){
        sendMessage();
    }

    @Async
    public void sendMessage(){
        LocalDateTime now =  LocalDateTime.now();
        System.out.println(now);
        kafkaTemplate.send("test","message send from Spring at "+ now);

    }

}
