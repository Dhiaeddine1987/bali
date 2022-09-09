package be.abvvfgtb.bali.member.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/**
 * Web Security.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

      http.csrf()
              .disable()
              .authorizeRequests()
              .antMatchers(HttpMethod.GET)
              .hasRole("ADMIN")
              .antMatchers("/v1/**")
              .hasAnyRole("ADMIN")
              .antMatchers("/user/**")
              .hasAnyRole("USER", "ADMIN")
              .antMatchers("/v1/**")
              .anonymous()
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic()
              .and()
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    http
//            .authorizeHttpRequests((requests) -> requests
//                    .antMatchers(HttpMethod.GET, "/v1/**")
//                    .permitAll()
//                    .anyRequest().authenticated()
//            );

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
            User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .build();

    return new InMemoryUserDetailsManager(user);
  }
}
