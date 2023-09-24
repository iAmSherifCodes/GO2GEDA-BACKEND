package com.go2geda.user.controller;

import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.commuter.service.CommuterService;
import com.go2geda.driver.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping("api/v1/go2geda")
//@CrossOrigin("http://localhost:3000/")
@CrossOrigin("*")
public class Go2GedaController {

    private final CommuterService commuterService;
    private final DriverService driverService;

    @PostMapping("/register-commuter")
    public ResponseEntity<RegisterUserResponse> registerCommuter(CommuterRegisterUserRequest request){
        return new ResponseEntity<>(commuterService.register(request), HttpStatus.OK);
    }

    @PostMapping("/register-driver")
    public ResponseEntity<RegisterUserResponse> registerDriver(DriverRegisterUserRequest request){
        return new ResponseEntity<>(driverService.register(request), HttpStatus.OK);
    }
}
