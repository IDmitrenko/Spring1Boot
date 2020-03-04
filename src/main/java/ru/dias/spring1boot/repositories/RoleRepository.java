package ru.dias.spring1boot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dias.spring1boot.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String theRoleName);
}
