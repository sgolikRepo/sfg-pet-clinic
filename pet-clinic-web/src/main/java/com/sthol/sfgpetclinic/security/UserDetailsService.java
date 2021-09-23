package com.sthol.sfgpetclinic.security;

import com.sthol.sfgpetclinic.model.User;
import com.sthol.sfgpetclinic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " +s + " is not found.");
        }
        return new com.sthol.sfgpetclinic.security.UserDetails(user);
    }
}
