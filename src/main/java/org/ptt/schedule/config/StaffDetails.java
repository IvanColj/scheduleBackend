package org.ptt.schedule.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ptt.schedule.model.Staff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class StaffDetails implements UserDetails {
    private final Staff staff;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        assert staff != null;
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + staff.getRole()));
    }

    @Override
    public String getPassword() {
        assert staff != null;
        return staff.getPassword();
    }

    @Override
    public String getUsername() {
        assert staff != null;
        return staff.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
