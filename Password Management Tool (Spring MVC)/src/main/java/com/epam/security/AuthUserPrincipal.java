package com.epam.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AuthUserPrincipal implements UserDetails
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private AuthUser authUser;


    public AuthUserPrincipal(AuthUser authUser)
    {
        super();
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {

        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword()
    {
        return this.authUser.getPassword();
    }

    @Override
    public String getUsername()
    {
        return this.authUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {

        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {

        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

}
