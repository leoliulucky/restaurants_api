package com.benxiaopao;

import com.benxiaopao.thrift.ThriftServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.benxiaopao.provider.dao.map")
public class RestaurantsApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestaurantsApiApplication.class, args);

        ThriftServer thriftServer = context.getBean(ThriftServer.class);
        thriftServer.start();
    }

}
