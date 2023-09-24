package com.go2geda.driver.service;

import com.go2geda.commuter.data.model.Address;
import com.go2geda.commuter.data.model.BasicInformation;
import com.go2geda.commuter.data.model.User;
import com.go2geda.commuter.data.repositories.BasicInformationRepository;
import com.go2geda.driver.data.repository.DriverRepository;
import com.go2geda.commuter.data.repositories.UserRepository;
import com.go2geda.driver.data.model.AccountDetails;
import com.go2geda.driver.data.model.Driver;
import com.go2geda.driver.data.model.DriverInformation;
import com.go2geda.driver.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.driver.dto.request.DriverLicenceVerificationRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.request.EmailSenderRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.user.enums.Role;
import com.go2geda.user.service.cloud.CloudService;
import com.go2geda.utils.exception.UserNotFound;
import com.go2geda.user.service.MailService;
import com.go2geda.user.service.UserService;
import com.go2geda.utils.BuildEmailRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.go2geda.user.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.user.dto.response.ResponseMessage.VERIFIED_SUCCESSFUL;
import static com.go2geda.utils.exception.ExceptionMessage.USER_NOT_FOUND;
import static com.go2geda.utils.AppUtils.*;

@Service @AllArgsConstructor @Slf4j
public class Go2gedaDriverService implements DriverService, UserService {


    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final BasicInformationRepository basicInformationRepository;
    private final CloudService cloudService;

    private final BuildEmailRequest buildEmailRequest;
    private final MailService mailService;

    @Override
    public RegisterUserResponse register(DriverRegisterUserRequest request)
    {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();
        newUser.setRole(Role.DRIVER);

        BasicInformation basicInformation =new BasicInformation();

        basicInformation.setFirstName(firstName);
        basicInformation.setLastName(lastName);
        basicInformation.setEmail(email);
        basicInformation.setPassword(password);
        basicInformation.setPhoneNumber(phoneNumber);


        newUser.setBasicInformation(basicInformation);


        Driver newDriver = new Driver();
        newDriver.setUser(newUser);

        Driver savedDriver = driverRepository.save(newDriver);
        log.info(savedDriver.toString());
        EmailSenderRequest emailSenderRequest = buildEmailRequest.buildEmailRequest(basicInformation);
        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());


        return response;
    }

    @Override
    public Driver findDriverByEmail(String email) {
        return driverRepository.findDriverByEmail(email).orElseThrow(()-> new UserNotFound(USER_NOT_FOUND.name()));
    }

    @Override
    public OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, String email) {
        Driver foundDriver = findDriverByEmail(email);

        DriverInformation driverInformation = new DriverInformation();

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountNUmber(accountDetailsVerificationRequest.getAccountNUmber());
        accountDetails.setBankName(accountDetailsVerificationRequest.getBankName());
        accountDetails.setBankVerificationNUmber(accountDetailsVerificationRequest.getBankVerificationNUmber());


        driverInformation.setAccountDetails(accountDetails);
        foundDriver.setDriverInformation(driverInformation);

        Driver saved = driverRepository.save(foundDriver);

        log.info(saved.toString());
        OkResponse okResponse = new OkResponse();
        okResponse.setMessage(VERIFICATION_SUCCESSFUL);
        return okResponse;
    }


    @Override
    public OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest) {

        MultipartFile frontLicensePicture = driverLicenceVerificationRequest.getFrontPicture();
        MultipartFile backLicensePicture = driverLicenceVerificationRequest.getBackPicture();

        cloudService.upload(frontLicensePicture, "driver-license");
        cloudService.upload(backLicensePicture, "driver-license");

        OkResponse response = new OkResponse();
        response.setMessage(UPLOAD_SUCCESSFUL);

        return response;
    }

    @Override
    public OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String email) {
        String localGovernment = addressVerificationRequest.getLocalGovernment();
        String state = addressVerificationRequest.getState();
        String homeAddress = addressVerificationRequest.getHomeAddress();

        Address newAddress = new Address();
        newAddress.setHomeAddress(homeAddress);
        newAddress.setState(state);
        newAddress.setLocalGovernment(localGovernment);

        Driver foundDriver = findDriverByEmail(email);
        foundDriver.getUser().setAddress(newAddress);

        driverRepository.save(foundDriver);

        OkResponse response = new OkResponse();
        response.setMessage(VERIFIED_SUCCESSFUL.name());

        return response;


    }
}
