package br.com.gym.gymcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GymcontrolApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymcontrolApplication.class, args);
    }

}
