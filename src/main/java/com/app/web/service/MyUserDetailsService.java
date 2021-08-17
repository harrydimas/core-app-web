package com.app.web.service;

import com.app.web.enums.PermissionEnum;
import com.app.web.enums.RoleEnum;
import com.app.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        try {
            User user = userService.getByLoginId(loginId);
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles(), user.getPermissions());
            return buildUserForAuthentication(user, authorities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getLoginPwd(),
                user.isEnabled(), true, true, !user.isLocked(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(int roles, String permissions) {

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(RoleEnum.getRole(roles)));
        Set<String> userPermissions = PermissionEnum.getUserPermissions(permissions);
        userPermissions.forEach(up -> authorities.add(new SimpleGrantedAuthority(up)));

        return new ArrayList<>(authorities);
    }

    public User getUserLogin() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user;
        try {
            user = userService.getByLoginId(auth.getName());
        } catch (Exception e) {
            user = new User();
            user.setLoginId("SYSTEM");
        }

        return user;
    }
}
