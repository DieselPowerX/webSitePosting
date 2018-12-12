package pl.konrad.feak_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class FeakNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeakNewsApplication.class, args);
	}
}
