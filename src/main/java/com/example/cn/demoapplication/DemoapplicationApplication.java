package com.example.cn.demoapplication;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DemoapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoapplicationApplication.class, args);

        /*JDK动态代理
        HelloProxy helloProxy = new HelloProxy(new HelloImpl());
        IHello proxy = helloProxy.getProxy();
        proxy.sayHello();*/

        /*CGLibProxy
        CGLibProxy cgLibProxy = new CGLibProxy();
        HelloWorld proxy = cgLibProxy.getProxy(HelloWorld.class);
        proxy.sayHello();*/

        /*Map<Integer, String> collect = (Map<Integer, String>) list.stream().collect(Collectors.toMap(User::getUid, User::getName));
        collect.forEach((k, v) -> System.out.println("key:" + k + ","+ "value:" + v));
*/
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        return connector;
    }

}
