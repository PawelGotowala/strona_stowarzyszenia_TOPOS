package pl.gotowala.strona_stowarzyszenia_topos.service;

import pl.gotowala.strona_stowarzyszenia_topos.model.UserRole;
import pl.gotowala.strona_stowarzyszenia_topos.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    //value laduje wartosci z ustawien(properties) do zmiennych
    @Value("${user.default.roles}")
    private String[] defaultRoles;


    @Override
    public Set<UserRole> getDefaultUserRoles() {
        HashSet<UserRole> roles = new HashSet<>();

        for(String role : defaultRoles){
            roles.add(userRoleRepository.findByName(role));
        }
        return roles;
    }


}
