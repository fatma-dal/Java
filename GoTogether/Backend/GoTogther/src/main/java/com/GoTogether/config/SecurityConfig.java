package com.GoTogether.config;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
	   private JwtAuthenticationFilter jwtAuthFilter;
	    private AuthenticationProvider authenticationProvider ;

  //  private final CustomAuthenticationSuccessHandler successHandler;

   // public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
     //   this.successHandler = successHandler;
   // }

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf
                .disable()) // Disables CSRF protection as it's not needed for stateless APIs
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/auth/**")
                        .permitAll() 
                        .anyRequest()
                        .authenticated() // Requires authentication for all other requests
                        .and()// Allows unrestricted access to authentication endpoints
                        //.requestMatchers("/api/users/**")
                        )
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider) // Sets the custom authentication provider
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Adds JWT filter before the default username/password authentication filter
  return http.build();
}

   // @Bean
    //public PasswordEncoder passwordEncoder() {
   //     return new BCryptPasswordEncoder();
    //}
}
