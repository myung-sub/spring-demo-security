package com.fxsong.demo.security.config;

import com.fxsong.demo.security.auth.UserDetailsServiceImpl;
import com.fxsong.demo.security.user.UserService;
import com.fxsong.demo.security.user.role.UserRoleService;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(req -> req
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/error*").permitAll()
                        .requestMatchers("/auth/login*").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())

                // login page
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )

                .httpBasic(Customizer.withDefaults())   // 없으면 Admin 에서 접속을 못함

                .logout(auth -> auth
                        .logoutUrl("/auth/logout")
                        .logoutSuccessUrl("/")
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                )

                .sessionManagement(session -> session
                        .invalidSessionUrl("/")
                        .maximumSessions(1)  // 최대 허용 세션수
                        .maxSessionsPreventsLogin(false) // true 이면 중복 로그인시 기존 세션을 끊음, false 이면 중복 로그인을 막음
                )

//                .sessionManagement(session -> session
//                        .sessionFixation().newSession() // 세션 고정 공격 방어
//                )

                // test 용도로 csrf 를 disable
//                .csrf(AbstractHttpConfigurer::disable)
//                .csrf(csrf -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                        .ignoringRequestMatchers(
//                                new AntPathRequestMatcher("/instances/**", HttpMethod.POST.toString()),
//                                new AntPathRequestMatcher("/instances/**", HttpMethod.DELETE.toString()),
//                                new AntPathRequestMatcher("/actuator/**"))
//                )
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService, UserRoleService userRoleService) {
        return new UserDetailsServiceImpl(userService, userRoleService);
    }

//    @Bean
//    public UserDetailsService users() {
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        UserDetails user = userBuilder
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = userBuilder
//                .username("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
