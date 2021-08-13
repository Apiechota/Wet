package pl.AP.wet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class WetSystemApplication implements CommandLineRunner{
@Autowired
JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(WetSystemApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {	
		
}

}
