package com.go2geda.appConfig;

import com.go2geda.data.model.User;
import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.request.MailInfo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.utils.AppUtils.generateActivationLink;
import static com.go2geda.utils.AppUtils.getMailTemplate;

@Configuration @Getter
public class AppConfig {
    public final static  String SPACE = " ";
    public static final String ACTIVATE_ACCOUNT_PATH="/user/activate?code=";
    public final static String WELCOME_MAIL_SUBJECT = "Welcome to Go2Geda Platform";


    @Value("${mail.api.key}")
    private String mailApiKey;

    @Value("${mail.brevo.address}")
    private String brevoMailAddress;


    @Value("${app.base.url}")
    private String baseUrl;


}
