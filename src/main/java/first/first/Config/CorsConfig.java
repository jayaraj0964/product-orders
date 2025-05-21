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
                registry.addMapping("/**")
        .allowedOrigins("*") // Temporarily allow all origins
        .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(false);   }
        };
    }
}