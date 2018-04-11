package homehub.homehubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomehubapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomehubapiApplication.class, args);
    }
}

