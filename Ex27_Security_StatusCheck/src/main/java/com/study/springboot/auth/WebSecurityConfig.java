package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/css/**", "/js/**", "/img/**").permitAll()
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/loginForm")			// default : /login
			.loginProcessingUrl("/j_spring_security_check")
			.failureUrl("/loginForm?error")			// default : /login?error
//			.defaultSuccessUrl("/")
			.usernameParameter("j_username")	// default : j_username
			.passwordParameter("j_password")	// default : j_password
			.permitAll();
		
		http.logout()
			.logoutUrl("/logout")				// default
			.logoutSuccessUrl("/")
			.permitAll();
		
		// ssl을 사용하지 않으면 true로 사용
		http.csrf().disable();
	}
	
	// 빠른 테스트를 위해 등록이 간단한 inMemory 방식의 인증 사용자 등록 => 테스트할때만 사용
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
		// ROLE_ADMIN에서 ROLE_은 자동으로 붙는다.
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
