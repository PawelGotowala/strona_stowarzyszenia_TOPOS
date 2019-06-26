package pl.gotowala.strona_stowarzyszenia_topos.service;

import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import pl.gotowala.strona_stowarzyszenia_topos.model.UserRole;
import pl.gotowala.strona_stowarzyszenia_topos.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = appUserRepository.findByEmail(email);
     if(appUserOptional.isPresent()){
         AppUser appUser = appUserOptional.get();

         String[] rolesArray = appUser.getRoles().stream().map(UserRole::getName).toArray(String[]::new);

         return User.builder()
                 .username(appUser.getEmail())
                 .password(appUser.getPassword())
                 .roles(rolesArray)
//                 .authorities(new ArrayList<>(getAuthorities(appUser.getRoles())))
                 .build();
     }

     throw new UsernameNotFoundException("unable to find user with username");

    }
/*
    private List<GrantedAuthority> getAuthorities(Set<UserRole> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(UserRole role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return grantedAuthorities;
    }
    */
}
