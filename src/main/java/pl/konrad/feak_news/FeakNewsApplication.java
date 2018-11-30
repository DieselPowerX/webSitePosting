package pl.konrad.feak_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class FeakNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeakNewsApplication.class, args);
	}
}
