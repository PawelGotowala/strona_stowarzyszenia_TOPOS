package pl.gotowala.strona_stowarzyszenia_topos.configuration;

import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import pl.gotowala.strona_stowarzyszenia_topos.model.UserRole;
import pl.gotowala.strona_stowarzyszenia_topos.repository.AppUserRepository;
import pl.gotowala.strona_stowarzyszenia_topos.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    //wywola sie raz po calej pelnej fazie inicjalizacji

        createRoleIfNotExist("ADMIN");
        createRoleIfNotExist("User");

        createUserWithRoleIfNotExist("admin","kniga","ADMIN","USER");
        createUserWithRoleIfNotExist("user","resu","USER");
    }

    private void createUserWithRoleIfNotExist(String username,String password, String... roles){
           if(!appUserRepository.existsByEmail(username)){
               AppUser appUser = new AppUser();
               appUser.setEmail(username);
               appUser.setPassword(passwordEncoder.encode(password));

               appUser.setRoles(new HashSet<>(findRoles(roles)));
               appUserRepository.save(appUser);
           }
    }

    private List<UserRole> findRoles(String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();
        for(String role : roles){
            userRoles.add(userRoleRepository.findByName(role));
        }
        return userRoles;
    }

    private void createRoleIfNotExist(String roleName){
        if(!userRoleRepository.existsByName(roleName)){
            UserRole role = new UserRole();
            role.setName(roleName);
            userRoleRepository.save(role);
        }
    }

}
