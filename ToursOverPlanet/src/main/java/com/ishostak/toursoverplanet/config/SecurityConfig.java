package com.ishostak.toursoverplanet.config;

import com.ishostak.toursoverplanet.entity.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/", "/registration", "/login", "/fragments/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/forbidden")
                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .successForwardUrl("/profile");
//                .and()
                .logout().logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/")
                .permitAll()
                .invalidateHttpSession(true);
    }
}
