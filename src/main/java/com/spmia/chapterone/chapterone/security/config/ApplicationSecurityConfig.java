package com.spmia.chapterone.chapterone.security.config;

 import com.spmia.chapterone.chapterone.security.enums.UserPermission;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpMethod;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

 import static com.spmia.chapterone.chapterone.security.enums.UserPermission.*;
 import static com.spmia.chapterone.chapterone.security.enums.UserRole.ADMIN;
import static com.spmia.chapterone.chapterone.security.enums.UserRole.USER;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/**").hasAuthority(READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                //.roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                //.roles(USER.name()) // ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
