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


    //Zookeeper config values previously defined in application-<env>.properties
    @Value("dbURL")
    private String dbURL;

    @Value("${dbUser}")
    private String dbUser;

    @Value("${dbPassword}")
    private String dbPassword;

    @Value("${other.nestedproperty}")
    private String otherNestedproperty;


    @RequestMapping(method = RequestMethod.GET, value = "/showpropertyvalues", produces = "text/plain")
    public String myresponse() throws UnknownHostException {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            hostname = "unknown";
        }


        return "This app is running on " + hostname  + ".\r\n" +
                "The configuration values are applied from internal property configuration files... \r\n\r\n" +
                "dbURLproperty = " + dbURL + "\r\n" +
                "dbUser = " + dbUser + "\r\n" +
                "dbPassword = " + dbPassword + "\r\n" +
                "other.nestedproperty = " + otherNestedproperty;
    }

}
