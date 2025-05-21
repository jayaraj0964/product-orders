package first.first.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins(
                            "http://localhost:3000", // For local development
                            "https://jayapp-git-main-jays-projects-bcd66f08.vercel.app" // Your Vercel frontend URL
                        )
                        .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE") // Include OPTIONS for preflight
                        .allowedHeaders("*")
                        .allowCredentials(false); // Set to true if you need to send cookies or auth headers
            }
        };
    }
}