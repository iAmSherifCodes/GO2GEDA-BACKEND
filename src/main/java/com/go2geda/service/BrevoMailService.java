package com.go2geda.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.data.model.User;
import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.request.MailInfo;
import com.go2geda.dto.response.OkResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.SPACE;
import static com.go2geda.appConfig.AppConfig.WELCOME_MAIL_SUBJECT;
import static com.go2geda.utils.AppUtils.generateActivationLink;
import static com.go2geda.utils.AppUtils.getMailTemplate;

@Service @AllArgsConstructor
public class BrevoMailService implements MailService{

    private final AppConfig appConfig;

    @Override
    public OkResponse send(EmailSenderRequest emailSenderRequest) {
//        String brevoMailAddress = "https://api.brevo.com/v3/smtp/email";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", appConfig.getMailApiKey());
        headers.set("Content-Type", "application/json");
        HttpEntity<EmailSenderRequest> request =
                new HttpEntity<>(emailSenderRequest, headers);

        ResponseEntity<OkResponse> response =
                restTemplate.postForEntity(appConfig.getBrevoMailAddress(), request, OkResponse.class);
        OkResponse emailNotificationResponse = response.getBody();
        return emailNotificationResponse;
    }

}
