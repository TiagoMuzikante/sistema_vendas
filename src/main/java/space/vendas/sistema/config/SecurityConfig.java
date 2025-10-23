package space.vendas.sistema.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

  private final JwtFilter filter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.POST, "/api/v1/usuarios").permitAll()
            .requestMatchers("/api/auth/**").permitAll()
            
            .requestMatchers("/swagger-ui/**").permitAll()
            .requestMatchers("/webjars/**").permitAll()
            .requestMatchers("/swagger-resources/**").permitAll()
            .requestMatchers("/v3/api-docs/**").permitAll()


            .anyRequest().authenticated()
        ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }


  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

}
