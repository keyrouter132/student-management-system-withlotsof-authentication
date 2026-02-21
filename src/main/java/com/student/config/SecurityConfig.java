package com.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http
        
        .authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/addStud", "/delStud", "/updateStud")
                .hasRole("ADMIN")
            .antMatchers("/viewAllStudent")
                .hasAnyRole("ADMIN", "USER")
            .anyRequest()
                .authenticated()
        .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .failureUrl("/login?error=true")
                .permitAll()
        .and()
        .sessionManagement()
        .invalidSessionUrl("/login?expired=true")        
                
        .and()
	        .logout()
		        .logoutSuccessHandler(logoutSuccessHandler)
		        .permitAll()
        .and()
            .exceptionHandling()
                .accessDeniedPage("/accessDenied");
}

    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    private CustomLoginSuccessHandler loginSuccessHandler;

    @Autowired
    private CustomLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}