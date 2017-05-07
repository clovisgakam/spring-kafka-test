package cm.gkc.kafka.configs;

/**
 * Created by gkc on 07/05/17.
 */

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {


    @Bean
    public Map<String,Object> producerConifg(){
        Map<String,Object> producerConfig = new HashMap<String,Object>() ;
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return  producerConfig ;
    }

    @Bean
    public ProducerFactory<Integer,String> producerFactory(){
        return  new DefaultKafkaProducerFactory<>(producerConifg());
    }

    @Bean
    public KafkaTemplate<Integer,String> kafkaTemplate(){
        return   new KafkaTemplate<Integer,String>(producerFactory());
    }



}
