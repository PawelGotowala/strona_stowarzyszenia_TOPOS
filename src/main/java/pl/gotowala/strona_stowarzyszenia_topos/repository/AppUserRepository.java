package pl.gotowala.strona_stowarzyszenia_topos.repository;


import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser,Long> {
     Optional<AppUser> findByEmail(String email);

     boolean existsByEmail(String email);
     void deleteAppUserByIdAfter(Long idAfter);
     void deleteAppUserByEmail(String albumNumber);
     AppUser getByEmail(String albumNumber);
 }
