//package com.go2geda.security.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
//import static com.go2geda.utils.AppUtils.APP_NAME;
//import static com.go2geda.utils.AppUtils.getPublicPaths;
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//
//public class Go2gedaAuthorizationFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if(getPublicPaths().contains(request.getServletPath())) filterChain.doFilter(request, response);
//        else{
//            String authorizationHeader = request.getHeader(AUTHORIZATION);//"Bearer xxxx_xxxx_xxxx..."
//
//
//            String token = authorizationHeader.substring("Bearer ".length());
//
//            JWTVerifier verifier = JWT.require(HMAC512("null_value"))
//                    .withIssuer(APP_NAME)
//                    .withClaimPresence("roles")
//                    .build();
//
//            DecodedJWT decodedJWT = verifier.verify(token);
//            List<SimpleGrantedAuthority> authorities = decodedJWT.getClaim("roles")
//                    .asList(SimpleGrantedAuthority.class);
//            Authentication authentication = new UsernamePasswordAuthenticationToken(null, null, authorities);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            filterChain.doFilter(request, response);
//        }
//    }
//}
