package co.za.codecol.emusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("co.za.codecol.emusic")
@SpringBootApplication
public class SpringBootDemoApplication {

	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
   
   
}

