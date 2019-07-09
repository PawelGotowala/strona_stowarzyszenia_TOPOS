package pl.gotowala.strona_stowarzyszenia_topos.service;



import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import java.util.List;

public interface UserService {

    void registerUser(String username, String password, String passwordConfirm);

    List<AppUser> getAllUsers();

    void deleteUser(int albumNumber);
}
