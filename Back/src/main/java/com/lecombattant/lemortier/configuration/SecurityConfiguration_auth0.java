/**
 * 
 */
package com.lecombattant.lemortier.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Lecombattant
 *
 */
/*
@EnableWebSecurity
@Configuration
*/
public class SecurityConfiguration_auth0 extends WebSecurityConfigurerAdapter {
	
	@Value(value = "${auth0.apiAudience}")
	private String apiAudience;
	
	@Value(value = "${auth0.issuer}")
	private String issuer;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
	    JwtWebSecurityConfigurer
        .forRS256(apiAudience, issuer)
        .configure(http)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/user/create").permitAll()
        .antMatchers(HttpMethod.GET, "/api/user/login").hasAuthority("view:registrations")
        .antMatchers(HttpMethod.GET, "/api/user/login/**").hasAuthority("view:registration")
        .antMatchers(HttpMethod.GET, "/api/v1/bikes").hasAuthority("view:registrations")
        .antMatchers(HttpMethod.GET, "/api/v1/bikes/**").hasAuthority("view:registration")
        .anyRequest().authenticated();
        */
	}

}
