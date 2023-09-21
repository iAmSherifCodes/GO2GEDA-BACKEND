package com.go2geda.utils;

import com.go2geda.exception.Go2gedaBaseException;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.ACTIVATE_ACCOUNT_PATH;
import static com.go2geda.utils.JwtUtils.generateVerificationToken;

public class AppUtils {
    public static final String APP_NAME = "Go2Geda";
    public static final String APP_EMAIL = "go2geda@mail.com";
    public static final String EMPTY_STRING ="";
    private static final String MAIL_TEMPLATE_LOCATION = "C:\\Users\\SHERIF\\IdeaProjects\\GO2GEDA-BACKEND\\GO2GEDA\\src\\main\\resources\\static\\emailHtml.html";

    public static String getMailTemplate() {
        Path templateLocation = Paths.get(MAIL_TEMPLATE_LOCATION);
        try {
            List<String> fileContents = Files.readAllLines(templateLocation);
            String template = String.join(EMPTY_STRING, fileContents);
            return template;
        }catch (IOException exception){
            throw new Go2gedaBaseException(exception.getMessage());
        }
    }

    public static String generateActivationLink(String baseUrl, String email){
        String token = generateVerificationToken(email);
        return baseUrl+ACTIVATE_ACCOUNT_PATH+token;
    }
}
