package com.spring.security;

import com.spring.entity.AppUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class AppUserDetails implements UserDetails {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean isEnabled;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isAccountNonExpired;

    public AppUserDetails() {
    }

    public AppUserDetails(AppUser user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.isEnabled = user.isEnabled();
        this.isCredentialsNonExpired = user.isCredentialsNonExpired();
        this.isAccountNonExpired = user.isAccountNonExpired();
        this.isAccountNonLocked = user.isAccountNonLocked();

        authorities = new ArrayList<>();
        if (!user.getRoles().isEmpty()){
            user.getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }
   }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
