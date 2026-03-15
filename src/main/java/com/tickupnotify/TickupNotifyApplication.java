package com.tickupnotify;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.RedirectView;

@OpenAPIDefinition(
        info = @Info(
                title = "TickUp Notify API",
                version = "1.0",
                description = "API pour l'envoi d'emails via TickUp Notify",
                contact = @Contact(
                        name = "TickUp Team",
                        email = "support@tickup.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)
@SpringBootApplication
public class TickupNotifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TickupNotifyApplication.class, args);
    }

    @Bean
    public RedirectView welcomePageRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/swagger-ui.html");
        return redirectView;
    }

}
