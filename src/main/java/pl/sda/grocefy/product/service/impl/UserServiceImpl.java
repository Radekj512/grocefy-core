package pl.sda.grocefy.product.service.impl;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.UserEntity;
import pl.sda.grocefy.product.mapper.UserMapper;
import pl.sda.grocefy.product.repository.UserRepository;
import pl.sda.grocefy.product.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO findUser(String username) {
        return userMapper.mapUser(userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("no such user")));
    }

    @Override
    @Transactional
    public void addUser(UserDTO newUser) {

        UserEntity userEntity = userMapper.mapUserToEntity(newUser);

           userEntity.setUsername(newUser.getUsername());
           userEntity.setEmail(newUser.getEmail());

        String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
        userEntity.setPassword(encryptedPassword);
        userRepository.save(userEntity);
    }

    @Override
    public Long getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Optional<UserEntity> user = userRepository.findByUsername(name);
        if (user.isPresent()){
            return user.get().getId();
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(userMapper::mapUser).collect(Collectors.toList());
    }

    @Override
    public UserDTO getLoggedUser() {
        Optional<UserEntity> user = userRepository.findById(getUserId());
        if (user.isPresent()) {
            return userMapper.mapUser(user.get());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public UserDTO findByID(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.mapUser(user.get());
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
