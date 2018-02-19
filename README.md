# Example Spring Zookeeper, YAML, property file example code and comparison:

## Step 1: 
Populate an instance of ZooKeeper with the example values. It can be localhost or a Zk Server running on your network. Configure via bootstrap.yml:

    /config  
        /spring-cloud-zookeeper-example  
            /dbURL = some_value  
            /dbUser = some_value  
            /dbPassword = some_value  
            /other  
                /nestedproperty = nestedPropValue
    
(see below for more details)

## Step 2:
Start the app WITHOUT passing a traditional Environment ID env. vars., that Spring would use to select values from a local property file.

e.g. no need for -DEnvironmentID={local or dev or int, etc}

Start the Spring Boot app (with embedded server), in your favorite IDE like IntelliJ    
...or run it with:  
mvn spring-boot:run


Test the service via GET (using a browser):
http://localhost:8080/api/showpropertyvalues

## YAML & Property file branches:
If want to see the same code running with internal YAML or Property files, switch to the YAML or PROPERTIES branches in Git.  
There is one config file for dev values and it is set as the default. If you don't pass in -DEnvironmentID=dev, the code will still run.  


## Setting sample configs in your local ZooKeeper using the zkCli.sh utility:  
    zkCli.sh
    create /config null  
    create /config/spring-cloud-zookeeper-example null  
    create /config/spring-cloud-zookeeper-example/dbURL jdbc:mysql://10.10.10.1:3306/    
    create /config/spring-cloud-zookeeper-example/dbUser zkDBUserValue  
    create /config/spring-cloud-zookeeper-example/dbPassword zkDBPasswordValue  
    create /config/spring-cloud-zookeeper-example/other  null
    create /config/spring-cloud-zookeeper-example/other/nestedproperty nestedPropValue


#More Tips:  
Making life even easier:  
Install and run zkui from GitHub locally, to give you a quick graphical way to edit you localhost Zookeeper:  
https://github.com/DeemOpen/zkui  

