package pl.gotowala.strona_stowarzyszenia_topos.repository;


import pl.gotowala.strona_stowarzyszenia_topos.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    boolean existsByName(String name);

    UserRole findByName(String role);

}
