package com.go2geda.controller;

import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.commuter.service.CommuterService;
import com.go2geda.driver.service.DriverService;
import com.go2geda.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController @AllArgsConstructor
@RequestMapping("api/v1/go2geda")
//@CrossOrigin("http://localhost:3000/api/v1/go2geda")
@CrossOrigin("*")
public class Go2GedaController {

    private final CommuterService commuterService;
    private final DriverService driverService;
    private final UserService userService;

    @PostMapping("/register-commuter")
    public ResponseEntity<RegisterUserResponse> registerCommuter(CommuterRegisterUserRequest request){
        return new ResponseEntity<>(commuterService.register(request), HttpStatus.OK);
    }

    @PostMapping("/register-driver")
    public ResponseEntity<RegisterUserResponse> registerDriver(@RequestBody DriverRegisterUserRequest request){
        return new ResponseEntity<>(driverService.register(request), HttpStatus.OK);
    }

    @PatchMapping("/activate/{email}")
//    @PreAuthorize("hasAnyAuthority('DRIVER', 'COMMUTER')")
    public ResponseEntity<OkResponse> activateAccount(@PathVariable String email){
        return ResponseEntity.ok(userService.activateAccount(email));
    }

    @PostMapping("/verify-address/{email}")
//    @PreAuthorize("hasAnyAuthority('DRIVER', 'COMMUTER')")
    public ResponseEntity<OkResponse> verifyAddress(AddressVerificationRequest addressVerificationRequest,@PathVariable String email){
        return ResponseEntity.ok(driverService.verifyAddress(addressVerificationRequest, email));
    }
}
