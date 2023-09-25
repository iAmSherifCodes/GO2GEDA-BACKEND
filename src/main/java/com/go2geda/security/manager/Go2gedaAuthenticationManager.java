//package com.go2geda.security.manager;
//
//import com.go2geda.utils.exception.AuthenticationNotSupportedException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import static com.go2geda.utils.exception.ExceptionMessage.AUTHENTICATION_NOT_SUPPORTED;
//
//@Component @RequiredArgsConstructor
//public class Go2gedaAuthenticationManager implements AuthenticationManager {
//
//    private final AuthenticationProvider authenticationProvider;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if(authenticationProvider.supports(authentication.getClass())){
//            Authentication authenticationResult = authenticationProvider.authenticate(authentication);
//            return authenticationResult;
//        }
//
//        throw new AuthenticationNotSupportedException(AUTHENTICATION_NOT_SUPPORTED.name());
//    }
//
//
//}
