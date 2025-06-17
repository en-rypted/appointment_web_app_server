package com.appointment.server.service;

import com.appointment.server.entity.User;
import com.appointment.server.entity.UserDetail;
import com.appointment.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(UserDetail::new)
                .orElseThrow(()->new UsernameNotFoundException("Username not found : "+username));
    }

    public UserDetails signup(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user =  userRepository.save(user);
        return  new UserDetail(user);
    }
}
