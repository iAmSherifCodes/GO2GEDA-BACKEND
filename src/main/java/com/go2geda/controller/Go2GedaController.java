package com.go2geda.controller;

import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.service.CommuterService;
import com.go2geda.service.DriverService;
import com.go2geda.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping("api/v1/go2geda")
@CrossOrigin("http://localhost:3000/")
public class Go2GedaController {

    public final UserService userService;
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
