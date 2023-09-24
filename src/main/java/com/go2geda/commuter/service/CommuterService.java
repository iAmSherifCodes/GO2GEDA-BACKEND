package com.go2geda.commuter.service;

import com.go2geda.commuter.data.model.Commuter;
import com.go2geda.commuter.data.model.User;
import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.user.dto.response.RegisterUserResponse;

public interface CommuterService {
    Commuter findCommuterByUser(User user);
    RegisterUserResponse register(CommuterRegisterUserRequest request);
}
