package com.go2geda.service;

import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.User;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.response.RegisterUserResponse;

public interface CommuterService {
    Commuter findCommuterByUser(User user);
    RegisterUserResponse register(CommuterRegisterUserRequest request);
}
