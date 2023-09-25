//package com.go2geda.security.services;
//
//import com.go2geda.security.models.SecureUser;
//import com.go2geda.user.data.model.User;
//import com.go2geda.user.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component @AllArgsConstructor
//public class Go2gedaUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findUserByEmail(username);
//        UserDetails userDetails = new SecureUser(user);
//
//        return userDetails;
//    }
//}
