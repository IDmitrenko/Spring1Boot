package ru.dias.spring1boot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dias.spring1boot.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
