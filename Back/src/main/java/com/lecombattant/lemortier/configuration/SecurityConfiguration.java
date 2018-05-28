/**
 * 
 */
package com.lecombattant.lemortier.configuration;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Lecombattant
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//@Autowired
    //private UserSecurityService userSecurityService;
	
	 private static final String SALT = "salt"; // Salt should be protected carefully

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        	.httpBasic()
        .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/api/user/create", "/home").permitAll()
          .anyRequest().authenticated()
		.and()
			.csrf()
			.disable();
	}
}
