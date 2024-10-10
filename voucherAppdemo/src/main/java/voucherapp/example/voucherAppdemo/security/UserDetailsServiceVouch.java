package voucherapp.example.voucherAppdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import voucherapp.example.voucherAppdemo.model.User;
import voucherapp.example.voucherAppdemo.repo.userRepo;


@Service
public class UserDetailsServiceVouch implements UserDetailsService {
    @Autowired
    private userRepo userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRep.findByEmail(username);
        if ((user == null)) {
            throw new UsernameNotFoundException("Invalid User: "+username) ;
        }
        
        return new org.springframework.security.core.userdetails
                    .User(user.getEmail(),user.getPassword(),user.getRole());
    }
}
