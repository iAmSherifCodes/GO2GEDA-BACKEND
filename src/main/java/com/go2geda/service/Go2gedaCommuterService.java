package com.go2geda.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.data.model.BasicInformation;
import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.User;
import com.go2geda.data.repositories.BasicInformationRepository;
import com.go2geda.data.repositories.CommuterRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.request.MailInfo;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.utils.BuildEmailRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.SPACE;
import static com.go2geda.appConfig.AppConfig.WELCOME_MAIL_SUBJECT;
import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.utils.AppUtils.generateActivationLink;
import static com.go2geda.utils.AppUtils.getMailTemplate;

@Service @AllArgsConstructor @Slf4j
public class Go2gedaCommuterService implements CommuterService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;
    private final BasicInformationRepository basicInformationRepository;
    private final MailService mailService;
    private final AppConfig appConfig;
    private final BuildEmailRequest buildEmailRequest;

    @Override
    public Commuter findCommuterByUser(User user) {
        return null;
    }

    @Override
    public RegisterUserResponse register(CommuterRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();
        BasicInformation basicInformation = new BasicInformation();

        basicInformation.setFirstName(firstName);
        basicInformation.setLastName(lastName);
        basicInformation.setEmail(email);
        basicInformation.setPassword(password);
        basicInformation.setPhoneNumber(phoneNumber);

        newUser.setRole(Role.COMMUTER);
        newUser.setBasicInformation(basicInformation);

        User savedUser = userRepository.save(newUser);
        //basicInformationRepository.save(basicInformation);

        Commuter newCommuter = new Commuter();
        newCommuter.setUser(savedUser);

        Commuter savedCommuter = commuterRepository.save(newCommuter);

        EmailSenderRequest emailSenderRequest = buildEmailRequest.buildEmailRequest(basicInformation);
        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());

        return response;
    }

}
