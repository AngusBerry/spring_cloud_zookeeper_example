#Step 1: 
Populate an instance of ZooKeeper on localhost with the example values:

    /config  
        /spring-cloud-zookeeper-example  
            /dbURL = some value  
            /dbUser = some value  
            /dbPassword = some value
    
(see below for more details)

#Step 2:
Start the app WITHOUT passing a traditional Environment ID env. vars., that Spring would use to select values from a local property file.

e.g. no need for -DEnvironmentID={local or dev or int, etc}

Start the Spring Boot app with embedded server, in your favorite IDE like IntelliJ  
...or build it and run it:  



Test the service via GET (using a browser):
http://localhost:8080/api/showzkvalues

#Setting sample configs in your local ZooKeeper using the zkCli.sh utility:  
    zkCli.sh
    create /config null  
    create /config/spring-cloud-zookeeper-example null  
    create /config/spring-cloud-zookeeper-example/dbURL jdbc:mysql://10.10.10.1:3306/    
    create /config/spring-cloud-zookeeper-example/dbUser zkDBUserValue  
    create /config/spring-cloud-zookeeper-example/dbPassword zkDBPasswordValue  


#More Tips:  
Making life even easier:  
Install and run zkui from GitHub, to give you a quick graphical way to edit you local Zookeeper:  
https://github.com/DeemOpen/zkui  

