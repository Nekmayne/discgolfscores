package haagahelia.discgolfscores;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.discgolfscores.domain.Course;
import haagahelia.discgolfscores.domain.CourseRepository;

@SpringBootApplication
public class DiscgolfscoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscgolfscoresApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
		return (args) -> {
			
			Course course1 = new Course("Joonas", "Keinukallio", 58, "20-04-2021", 61);
			Course course2 = new Course("Joonas", "Tali", 61, "20-04-2021", 54);
			
			repository.save(course1);
			repository.save(course2);
			
	};
	}
}
