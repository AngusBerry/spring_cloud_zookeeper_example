package com.mycompany.springcloudzkexample.spring_cloud_zookeeper_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SpringCloudZookeeperExampleApplication {

//    @Autowired
//    private ControllerSpringCloudZK controllerSpringCloudZK;

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudZookeeperExampleApplication.class, args);
	}
}
