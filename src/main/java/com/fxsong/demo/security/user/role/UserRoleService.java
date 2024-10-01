package com.fxsong.demo.security.user.role;

import com.fxsong.demo.security.system.CrudServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleService extends CrudServiceImpl<UserRole, Long> {
    private final UserRoleRepository repo;
    public UserRoleService(UserRoleRepository repo) {
        super(repo);
        this.repo = repo;
    }

    public List<UserRole> findByEmpNo(String empNo) {
        return repo.findByEmpNo(empNo);
    }
}
