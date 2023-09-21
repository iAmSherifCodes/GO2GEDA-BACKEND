package com.go2geda.service;

import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.request.MailInfo;
import com.go2geda.dto.response.OkResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static com.go2geda.utils.AppUtils.getMailTemplate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BrevoMailServiceTest {

    @Autowired
    private MailService mailService;
    private EmailSenderRequest emailSenderRequest;

    @Test
    void testEmail(){
        emailSenderRequest = new EmailSenderRequest();
        emailSenderRequest.setSubject("WELCOME DEAR USER");
        emailSenderRequest.setTo(Collections.singletonList(new MailInfo("test mail","gimivo5293@alvisani.com")));
        emailSenderRequest.setHtmlContent(getMailTemplate());

        OkResponse response = mailService.send(emailSenderRequest);

        assertThat(response).isNotNull();

    }



}
