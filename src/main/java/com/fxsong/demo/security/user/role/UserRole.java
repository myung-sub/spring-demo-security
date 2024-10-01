package com.fxsong.demo.security.user.role;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_USER_ROLE")
@Data
@Builder
public class UserRole {
    @Id
    private Long id;
    private String empNo;
    private String role;
}
