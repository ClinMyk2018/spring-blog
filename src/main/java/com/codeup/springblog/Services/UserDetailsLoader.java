package com.codeup.springblog.Services;

import com.codeup.springblog.Model.Users;
import com.codeup.springblog.Model.UserWithRoles;
import com.codeup.springblog.Repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user = users.findByname(name);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + name);
        }

        return new UserWithRoles(user);
    }
}
