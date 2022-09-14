package com.sadegh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled from users WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authorityType from authorities where username=? ")
                .passwordEncoder(passwordEncoder());


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //this method is for resources
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").permitAll();// every one can see

        http.authorizeRequests().
                antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/customer/**").access("hasRole('USER')")
                .and().logout().logoutSuccessUrl("/login?logout")
                .and().formLogin().loginPage("/login").successHandler(successHandler())
                .loginProcessingUrl("")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/");
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler successHandler(){
        return new SavedRequestAwareAuthenticationSuccessHandler();
    }

}
