package com.go2geda.service;

import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.User;
import com.go2geda.data.repositories.CommuterRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;

@Service @AllArgsConstructor @Slf4j
public class Go2gedaCommuterService implements CommuterService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;

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

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);

        log.info(firstName);
        newUser.setRole(Role.COMMUTER);
        User savedUser = userRepository.save(newUser);

        Commuter newCommuter = new Commuter();
        newCommuter.setUser(savedUser);

        Commuter savedCommuter = commuterRepository.save(newCommuter);
//        EmailSenderRequest emailSenderRequest = buildEmailRequest(savedUser);
//        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());

        return response;
    }
}
