package com.Major.majorProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @GetMapping("/")
    public ResponseEntity<String> ownerPage(){
        return new ResponseEntity<>("owner page", HttpStatus.OK);
    }

//    public ResponseEntity<> ownerRegisteration(){
//
//        return new ResponseEntity<>();
//    }
}
