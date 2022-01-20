package com.example.springboot_project_eind.security;

import com.example.springboot_project_eind.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;

import static org.springframework.http.HttpMethod.*;

@CrossOrigin
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
//              .antMatchers(OPTIONS).permitAll()
                .antMatchers(POST, "/authenticate").permitAll()
//               .antMatchers(OPTIONS, "/authenticate").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(GET, "/consult").hasAnyRole("USER", "ADMIN")
                .antMatchers(PATCH,"/users/{username}/password").authenticated()
                .antMatchers(GET, "/users/{username}/authorities" ).hasRole("ADMIN")
                .antMatchers(PATCH, "/users/{username}/authorities" ).hasRole("ADMIN")
                .antMatchers(DELETE, "/users/{username}/authorities/{authority}" ).hasRole("ADMIN")
                .antMatchers(POST, "/users").permitAll()
                .antMatchers(GET, "/users/{username}").permitAll()
                .antMatchers(POST, "/products/**").hasRole("ADMIN")
                .antMatchers(GET, "/file-upload").hasAnyRole("USER", "ADMIN")
                .antMatchers(GET, "/file-upload/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(PUT, "/file-upload/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(POST, "/file-upload/{username}").hasRole("USER")
                .antMatchers(DELETE, "/file-upload/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(DELETE, "/users/{username}").hasRole("ADMIN")
                .antMatchers(PUT, "/users/{username").authenticated()
                .antMatchers(GET, "/consult").hasAnyRole("USER", "ADMIN")
                .antMatchers(GET, "/consult/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(PUT, "/consult/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(DELETE, "/consult/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(POST, "/consult/{username}").permitAll()
                .antMatchers(GET,"/public").permitAll()
                .anyRequest().denyAll()
                .and()
                .cors().and().csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }



}
