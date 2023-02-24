package com.springbootbackendvolunteering.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailService customUserDeatailsService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/get"),
						new AntPathRequestMatcher("/addUser"), new AntPathRequestMatcher("/login"),
						new AntPathRequestMatcher("/swagger-resources/**"),
						new AntPathRequestMatcher("/swagger-ui.html"), new AntPathRequestMatcher("/swagger-ui/**"),
						new AntPathRequestMatcher("/v2/api-docs/**"), new AntPathRequestMatcher("/webjars/**"),
						new AntPathRequestMatcher("/api/v2/api-docs**"))
				.permitAll()
				.anyRequest().authenticated().and().cors().and().exceptionHandling()
				.authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		http.authenticationProvider(daoAuthenticationProvider());
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		return defaultSecurityFilterChain;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(8);
	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDeatailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
