package com.go2geda.user.service;

import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.response.OkResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String email);

}
