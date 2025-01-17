package com.gensanitydev.ServerGenSanHotel.service.impl;

import com.gensanitydev.ServerGenSanHotel.dto.LoginRequest;
import com.gensanitydev.ServerGenSanHotel.dto.Response;
import com.gensanitydev.ServerGenSanHotel.entity.User;
import com.gensanitydev.ServerGenSanHotel.repo.UserRepository;
import com.gensanitydev.ServerGenSanHotel.service.interfac.IUserService;
import com.gensanitydev.ServerGenSanHotel.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public Response register(User loginRequest) {
        return null;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response getAllUsers() {
        return null;
    }

    @Override
    public Response getUserBookingHistory(String userId) {
        return null;
    }

    @Override
    public Response deleteUser(String userId) {
        return null;
    }

    @Override
    public Response getUserById(String userId) {
        return null;
    }

    @Override
    public Response getMyInfo(String userId) {
        return null;
    }
}
