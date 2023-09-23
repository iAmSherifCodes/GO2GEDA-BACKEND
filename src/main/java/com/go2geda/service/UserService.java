package com.go2geda.service;

import com.go2geda.dto.request.AddressVerificationRequest;
import com.go2geda.dto.response.OkResponse;

public interface UserService {
    OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String email);
}
