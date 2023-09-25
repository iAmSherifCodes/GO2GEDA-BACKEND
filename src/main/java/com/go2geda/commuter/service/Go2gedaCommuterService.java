package com.go2geda.commuter.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.user.data.model.BasicInformation;
import com.go2geda.commuter.data.model.Commuter;
import com.go2geda.user.data.model.User;
import com.go2geda.user.data.repository.BasicInformationRepository;
import com.go2geda.commuter.data.repositories.CommuterRepository;
import com.go2geda.user.data.repository.UserRepository;
import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.user.dto.request.EmailSenderRequest;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.user.enums.Role;
import com.go2geda.user.service.MailService;
import com.go2geda.user.service.UserService;
import com.go2geda.utils.BuildEmailRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.go2geda.user.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;

@Service @AllArgsConstructor @Slf4j
public class Go2gedaCommuterService implements CommuterService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;
    private final MailService mailService;
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

        Commuter newCommuter = new Commuter();
        newCommuter.setUser(savedUser);

        Commuter savedCommuter = commuterRepository.save(newCommuter);

        EmailSenderRequest emailSenderRequest = buildEmailRequest.buildEmailRequest(newUser);
        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());

        return response;
    }


}
