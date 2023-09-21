package com.go2geda.service;

import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.response.OkResponse;

public interface MailService {
    OkResponse send(EmailSenderRequest request);
}
