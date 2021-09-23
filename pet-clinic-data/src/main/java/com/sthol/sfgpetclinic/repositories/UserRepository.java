package com.sthol.sfgpetclinic.repositories;

import com.sthol.sfgpetclinic.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
