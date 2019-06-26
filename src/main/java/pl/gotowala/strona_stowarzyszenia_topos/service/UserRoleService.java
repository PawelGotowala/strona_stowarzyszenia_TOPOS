package pl.gotowala.strona_stowarzyszenia_topos.service;


import pl.gotowala.strona_stowarzyszenia_topos.model.UserRole;

import java.util.Set;

public interface UserRoleService {
   Set<UserRole> getDefaultUserRoles();
}
