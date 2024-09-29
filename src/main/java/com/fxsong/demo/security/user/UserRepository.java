package com.fxsong.demo.security.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findBySoeid(String soeid);
}
