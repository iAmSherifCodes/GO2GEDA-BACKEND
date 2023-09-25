package com.go2geda.service;

import com.go2geda.user.dto.request.EmailSenderRequest;
import com.go2geda.user.dto.request.MailInfo;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static com.go2geda.utils.AppUtils.getMailTemplate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BrevoMailServiceTest {

    @Autowired
    private MailService mailService;
//    private EmailSenderRequest emailSenderRequest;

    @Test
    void testEmail(){
        EmailSenderRequest emailSenderRequest = new EmailSenderRequest();
        emailSenderRequest.setSubject("WELCOME DEAR USER");
        emailSenderRequest.setTo(Collections.singletonList(new MailInfo("test mail","cashgraphicx@gmail.com")));
        emailSenderRequest.setHtmlContent(getMailTemplate());

        OkResponse response = mailService.send(emailSenderRequest);

        assertThat(response).isNotNull();

    }



}
