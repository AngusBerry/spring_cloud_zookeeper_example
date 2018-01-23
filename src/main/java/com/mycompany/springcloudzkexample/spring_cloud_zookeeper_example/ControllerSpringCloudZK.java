package com.mycompany.springcloudzkexample.spring_cloud_zookeeper_example;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping("/api")
public class ControllerSpringCloudZK {

    //local values directly from application.yml
    @Value("${spring.cloud.zookeeper.connect-string}")
    private String springCloudZookeeperConnectString;


    //Zookeeper config values defined in application.yml
    @Value("${dbURL}")
    private String dbURL;

    @Value("${dbUser}")
    private String dbUser;

    @Value("${dbPassword}")
    private String dbPassword;


    @RequestMapping(method = RequestMethod.GET, value = "/showzkvalues", produces = "text/plain")
    public String myresponse() throws UnknownHostException {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            hostname = "unknown";
        }


        return "This app is running on " + hostname  + ".\r\n" +
                "The configuration values are applied from Zookeeper running on " + springCloudZookeeperConnectString + "... \r\n\r\n" +
                "zkdbURLproperty = " + dbURL + "\r\n" +
                "zkdbUser = " + dbUser + "\r\n" +
                "zkdbPassword = " + dbPassword;
    }

}
