package com.fxsong.demo.security.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_USER")
@Data
@Builder
public class User {
    @Id
    private Long id;
    private String empNo;
    private String password;
    private String name;
}
