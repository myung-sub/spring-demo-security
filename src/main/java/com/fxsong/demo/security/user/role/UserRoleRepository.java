package com.fxsong.demo.security.user.role;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findByEmpNo(String empNo);
}
