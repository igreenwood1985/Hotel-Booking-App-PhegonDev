package com.gensanitydev.ServerGenSanHotel.service.interfac;

import com.gensanitydev.ServerGenSanHotel.dto.LoginRequest;
import com.gensanitydev.ServerGenSanHotel.dto.Response;
import com.gensanitydev.ServerGenSanHotel.entity.User;

public interface IUserService {

    Response register(User loginRequest);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser (String userId);

    Response getUserById(String userId);

    Response getMyInfo(String userId);


}
