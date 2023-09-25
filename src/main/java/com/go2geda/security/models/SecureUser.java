//package com.go2geda.security.models;
//
//import com.go2geda.user.data.model.User;
//import com.go2geda.user.enums.Role;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@AllArgsConstructor
//public class SecureUser implements UserDetails {
//    private final User user;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Role role = user.getRole();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(role.name());
//        authorities.add(userAuthority);
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getBasicInformation().getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getBasicInformation().getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//
////        return user.isVerified();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return user.isActive();
//    }
//}
