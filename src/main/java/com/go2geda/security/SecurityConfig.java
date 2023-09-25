//package com.go2geda.security;
//
//import com.go2geda.security.filter.Go2gedaAuthenticationFilter;
//import com.go2geda.security.filter.Go2gedaAuthorizationFilter;
//import io.netty.handler.codec.http.HttpServerCodec;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static com.go2geda.user.enums.Role.DRIVER;
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration @AllArgsConstructor
//public class SecurityConfig {
//
//    private final AuthenticationManager authenticationManager;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        final String[] publicEndpoints = {"api/v1/go2geda", "/login"};
//        final String[] sharedEndpoints = {
////                                             "api/v1/go2geda"
//                                         };
//        final String[] driverEndPoints = {"api/v1/go2geda/register-driver"};
//        final String[] commuterEndPoints = {};
//        final String[] adminEndPoints = {};
//
//        return httpSecurity
//                .addFilterAt(new Go2gedaAuthenticationFilter(authenticationManager),
//                        UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new Go2gedaAuthorizationFilter(),
//                        Go2gedaAuthorizationFilter.class)
//                .sessionManagement(customizer->customizer.sessionCreationPolicy(STATELESS))
//                .csrf(c->c.disable())
//                .cors(Customizer.withDefaults())
//                .authorizeHttpRequests(c->c.requestMatchers(POST, publicEndpoints).permitAll())
//                .authorizeHttpRequests(c->c.anyRequest().hasAuthority(DRIVER.name()))
//                .authorizeHttpRequests(c->c.requestMatchers(GET, sharedEndpoints).hasAnyAuthority(new String[]{"ADMIN", "CUSTOMER"}))
//                .build();
//    }
//}
