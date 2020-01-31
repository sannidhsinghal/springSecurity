package com.sannidh.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan("com.sannidh.practice")
@EnableJpaRepositories("com.sannidh.practice.repository")
@EntityScan("com.sannidh.practice.entity")
@EnableTransactionManagement
@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(PracticeApplication.class, args);
		String port = context.getEnvironment().getProperty("server.port");
		openHomePage(port);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

	private static void openHomePage(String port) {
		String url = String.format("http://localhost:%s/swagger-ui.html", port);
		if(Desktop.isDesktopSupported()){
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}else{
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
