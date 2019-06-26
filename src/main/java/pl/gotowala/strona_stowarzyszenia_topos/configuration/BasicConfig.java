package pl.gotowala.strona_stowarzyszenia_topos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BasicConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
         return new BCryptPasswordEncoder();
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //jesli nie ma mappingu na adres static (niema kontrolera)
          if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            //dodaj do handlerow - na adres static wskaz
        }
    }
}
