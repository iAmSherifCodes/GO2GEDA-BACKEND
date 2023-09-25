package com.go2geda.utils;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.user.data.model.BasicInformation;
import com.go2geda.user.data.model.User;
import com.go2geda.user.dto.request.EmailSenderRequest;
import com.go2geda.user.dto.request.MailInfo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.SPACE;
import static com.go2geda.appConfig.AppConfig.WELCOME_MAIL_SUBJECT;
import static com.go2geda.utils.AppUtils.generateActivationLink;
import static com.go2geda.utils.AppUtils.getMailTemplate;

@AllArgsConstructor @Configuration
public class BuildEmailRequest {

    private AppConfig appConfig;

    public EmailSenderRequest buildEmailRequest(User savedUser){
        EmailSenderRequest request =new EmailSenderRequest();
        List<MailInfo> recipients = new ArrayList<>();
        MailInfo recipient = new MailInfo(savedUser.getBasicInformation().getFirstName() + SPACE + savedUser.getBasicInformation().getLastName(), savedUser.getBasicInformation().getEmail());
        recipients.add(recipient);
        request.setTo(recipients);
        request.setSubject(WELCOME_MAIL_SUBJECT);
        String activationLink =
                generateActivationLink(appConfig.getBaseUrl(), savedUser.getBasicInformation().getEmail());
        String emailTemplate = getMailTemplate();
        String mailContent = String.format(emailTemplate, savedUser.getBasicInformation().getFirstName(), activationLink);
        request.setHtmlContent(mailContent);
        return request;
    }
}
