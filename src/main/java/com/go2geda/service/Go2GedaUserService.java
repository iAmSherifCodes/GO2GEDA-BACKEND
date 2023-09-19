package com.go2geda.service;

import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.Driver;
import com.go2geda.data.model.User;
import com.go2geda.data.repositories.CommuterRepository;
import com.go2geda.data.repositories.DriverRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.request.LoginRequest;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.go2geda.dto.response.ResponseMessage.LOGIN_SUCCESSFUL;
import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class Go2GedaUserService implements UserService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;
    private final DriverRepository driverRepository;

    @Override
    public RegisterUserResponse register(CommuterRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = map(firstName, lastName, email, password, phoneNumber);
        newUser.setRole(Role.COMMUTER);
        User savedUser = userRepository.save(newUser);

        Commuter newCommuter = new Commuter();
        newCommuter.setUser(savedUser);

        commuterRepository.save(newCommuter);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());

        return response;
    }


    @Override
    public RegisterUserResponse register(DriverRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = map(firstName, lastName, email, password, phoneNumber);
        newUser.setRole(Role.DRIVER);
        User savedUser = userRepository.save(newUser);

        Driver newDriver = new Driver();
        newDriver.setUser(savedUser);

        driverRepository.save(newDriver);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());


        return response;
    }

    private static User map(String firstName, String lastName, String email, String password, String phoneNumber) {
        User newUser = new User();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);

        return newUser;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User foundUser = userRepository.findByEmail(email).filter(user->user.getPassword().equals(password)).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));

        log.info(String.valueOf(foundUser.getRole()));
        LoginResponse response = new LoginResponse();
        response.setMessage(LOGIN_SUCCESSFUL.name());
        return response;

    }
}
