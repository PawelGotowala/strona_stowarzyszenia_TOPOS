package pl.gotowala.strona_stowarzyszenia_topos.service;

import pl.gotowala.strona_stowarzyszenia_topos.exception.PasswordDoNotMatchException;
import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import pl.gotowala.strona_stowarzyszenia_topos.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;
    private UserRoleService userRoleService;

    @Autowired
    public UserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, UserRoleService userRoleService) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    @Override
    public void registerUser(String username, String password, String passwordConfirm) {
     if(!password.equals(passwordConfirm)){
         //hasłą sie nie zgadzają
         throw new PasswordDoNotMatchException("Password and Password Confirm do not match.");
     }
     if(password.length() <= 2){
         throw new PasswordDoNotMatchException("Password must be at least 3 character.");
     }
     AppUser appUser=new AppUser();
     appUser.setEmail(username);
     //szyfruje haslo encode
     appUser.setPassword(passwordEncoder.encode(password));

     //nadanie uprawnien/ ppbranie domyślnych uprawnień z userRoleService (Który łąduje z konfiguracji)
        appUser.setRoles(userRoleService.getDefaultUserRoles());

        //zapis do bazy
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }


}
