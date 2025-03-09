package com.example.HospitalManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

   
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        PasswordEncoder encoder = passwordEncoder();
        authenticationManagerBuilder
            .inMemoryAuthentication()
            .withUser("nikita")
            .password(encoder.encode("password"))
            .roles("USER", "PATIENT")
            .and()
            .withUser("divya")
            .password(encoder.encode("password"))
            .roles("USER", "RECEPTIONIST")
            .and()
            .withUser("aditya")
            .password(encoder.encode("password"))
            .roles("USER", "DOCTOR");
        return authenticationManagerBuilder.build();
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .requestMatchers("/").permitAll()
                .requestMatchers("/images/**").permitAll()
            .requestMatchers("/main").permitAll()
            .requestMatchers("/signup").permitAll()
           //.requestMatchers("/doctors").permitAll()
            .requestMatchers("/doctors/**").hasRole("DOCTOR")
            //.requestMatchers("/patients").permitAll()
            .requestMatchers("/updateAppointment/**").permitAll()
                        .requestMatchers("/rooms/**").permitAll()
            .requestMatchers("/receptionist").permitAll()
            .requestMatchers("/receptionist/**").hasRole("RECEPTIONIST")
            .requestMatchers("/anonymous*").anonymous()
            .requestMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            .and()
//            .httpBasic();   
            .formLogin();
            
//            .defaultSuccessUrl("/showPostLogin", false)
//            .permitAll()
//            .and()
//            .logout()
//            .logoutSuccessUrl("/")
//            .permitAll();
        
        return http.build();
    }
}
