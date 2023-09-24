package com.go2geda.user.service;

import com.go2geda.user.dto.request.EmailSenderRequest;
import com.go2geda.user.dto.response.OkResponse;

public interface MailService {
    OkResponse send(EmailSenderRequest request);
}
