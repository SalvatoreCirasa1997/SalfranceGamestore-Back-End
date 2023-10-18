package it.Salfrance.SalfranceGamestore.config;

import it.Salfrance.SalfranceGamestore.auth.JwtAuthenticationFilter;
import it.Salfrance.SalfranceGamestore.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeConfig->
                        authorizeConfig.requestMatchers("/public").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/error").permitAll()
                                .requestMatchers("/accessorio/admin/**").hasRole(Role.ADMIN.getRuoloTrimmed())
                                .requestMatchers("/user/**").hasRole(Role.USER.getRuoloTrimmed())
                                .anyRequest()
                                .authenticated()
                        )
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authenticationProvider)
                        .csrf(AbstractHttpConfigurer::disable)
                        .build();
    }
}
