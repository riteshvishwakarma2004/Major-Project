package com.Major.majorProject.controller;

import com.Major.majorProject.dto.CafeAdditionDto;
import com.Major.majorProject.dto.OwnerRegistrationDto;
import com.Major.majorProject.service.OwnerService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addCafe")
    public ResponseEntity<CafeAdditionDto> cafeAddition(@RequestBody CafeAdditionDto cad ){
       ownerService.cafeAddition(cad);
       return new ResponseEntity<>(cad,HttpStatus.CREATED);
    }

    @GetMapping("/cafes")
    public ResponseEntity<List<CafeAdditionDto>> getAllCafeOfOwner(){
        List<CafeAdditionDto> cafes = ownerService.getAllCafeOfOwner();

        return new ResponseEntity<>(cafes,HttpStatus.OK);
    }
}