package registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public static void setSystemProperties() {
        Properties prop = new Properties();
        String propFile = "config.properties";
        try {
            InputStream readFile = Application.class.getClassLoader().getResourceAsStream(propFile);
            prop.load(readFile);
        } catch (Exception e) {
            System.out.println("Can not read configuration file: \n" + e.getLocalizedMessage());
        }
        System.setProperty("dbURL", prop.getProperty("dbURL"));
        System.setProperty("dbUserName", prop.getProperty("dbUserName"));
        System.setProperty("dbPassword", prop.getProperty("dbPassword"));
    }
}