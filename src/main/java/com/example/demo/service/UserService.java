package com.example.demo.service;
import com.example.demo.dto.user.UserRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .email(user.getEmail())
                .city(user.getCity())
                .build();
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponse findById(Long id) {
        return toResponse(userRepository.findById(id).orElseThrow());
    }

    public UserResponse save(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .age(userRequest.getAge())
                .email(userRequest.getEmail())
                .city(userRequest.getCity())
                .build();
        userRepository.save(user);
        return toResponse(user);
    }

    public UserResponse update(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id).orElseThrow();

        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        user.setCity(userRequest.getCity());

        userRepository.save(user);
        return toResponse(user);
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}