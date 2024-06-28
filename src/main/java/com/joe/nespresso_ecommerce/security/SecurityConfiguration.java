package com.joe.nespresso_ecommerce.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf(request -> request
                .ignoringRequestMatchers("/productadd", "/cartupdate")
            )
            .authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/**").permitAll()
                // .requestMatchers("/**").hasRole("CUSTOMER")
            )
            .formLogin(form -> form
                .loginPage("/loginpage")
                .loginProcessingUrl("/login")
                .successHandler(customAuthenticationSuccessHandler)
                // .defaultSuccessUrl("/", true)
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSION_ID")
                .invalidateHttpSession(true)
            );
                

        return http.build();
    }

    //Configuring the userDetails Manager to use JdbcUserDetailsManager
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
         return new JdbcUserDetailsManager(dataSource);
    }




    //Creating a Bean of BcryptPasswordEncoder to use it to encode passwords
    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}	
}
