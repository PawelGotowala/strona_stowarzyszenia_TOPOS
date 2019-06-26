package pl.gotowala.strona_stowarzyszenia_topos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.gotowala.strona_stowarzyszenia_topos.service.LoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;
//tutaj ten poczatek ogarnac , zlikwidowac brak zabezpieczenia, slack
    @Override
    protected void configure(HttpSecurity http) throws Exception{
         http.csrf().disable()
                 .authorizeRequests()
                   .antMatchers("/",
                   "/user/register",
                      "/login").permitAll()
                   .antMatchers("/admin/**").hasRole("ADMIN")
                   .antMatchers("/members/list/search").hasRole("User")
                 .and()
                 .formLogin()
                      .loginPage("/login")
                      .successForwardUrl("/")
                      .defaultSuccessUrl("/")
                      .permitAll()
                 .and()
                 .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .permitAll();
                
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(loginService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthenticationProvider());
    }
}
