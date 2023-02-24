package com.springbootbackendvolunteering.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtilTokenHelper jwtUtilTokenHelper;

	@Autowired
	private CustomUserDetailService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestTokenHandler = request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;

		if (requestTokenHandler != null && requestTokenHandler.startsWith("Bearer")) {
			jwtToken = requestTokenHandler.substring(7);
			try {
				userName = this.jwtUtilTokenHelper.getUserEmailFromToken(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("token is not validated...........");
			}

		}
		filterChain.doFilter(request, response);
	}

}
