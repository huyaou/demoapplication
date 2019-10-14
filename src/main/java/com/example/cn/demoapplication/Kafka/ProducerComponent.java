package com.example.cn.demoapplication.Kafka;

import org.springframework.stereotype.Component;

@Component
public class ProducerComponent {

    // https://www.jianshu.com/p/31d6979a7974

    // https://www.jianshu.com/p/d3e963ff8b70

    // https://blog.csdn.net/u013256816/article/details/71091774

    /*@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;*/

    public void sendMessage(String topic, Object message) {
        //kafkaTemplate.send(topic, JSONObject.toJSONString(message));
    }
}
