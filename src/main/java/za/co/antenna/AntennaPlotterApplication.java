package za.co.antenna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// SpringBootKanbanBoardApplication


@SpringBootApplication
public class AntennaPlotterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AntennaPlotterApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AntennaPlotterApplication.class);
	}
	

}
