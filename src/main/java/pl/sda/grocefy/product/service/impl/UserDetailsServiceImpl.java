package pl.sda.grocefy.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.grocefy.product.entity.UserEntity;
import pl.sda.grocefy.product.repository.UserRepository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byLogin=userRepository.findByUsername(username);
//        if(user==null){
//            throw new UsernameNotFoundException("Username not found");
//        }
       UserEntity user = byLogin.orElseThrow(()->new UsernameNotFoundException("Not Found user with login " +username));
        return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserEntity user)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return authorities;
    }
}


