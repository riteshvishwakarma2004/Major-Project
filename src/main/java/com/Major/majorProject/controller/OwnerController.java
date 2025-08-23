package com.Major.majorProject.controller;

import com.Major.majorProject.dto.OwnerRegistrationDto;
import com.Major.majorProject.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService os){
        this.ownerService = os;
    }

    @GetMapping("/")
    public ResponseEntity<String> ownerPage(){
        return new ResponseEntity<>("owner page", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<OwnerRegistrationDto> ownerRegisteration(@RequestBody OwnerRegistrationDto ord){
        OwnerRegistrationDto dto = ownerService.ownerRegistration(ord);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}
