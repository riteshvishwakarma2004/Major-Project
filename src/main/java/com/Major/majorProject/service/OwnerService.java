package com.Major.majorProject.service;

import com.Major.majorProject.dto.CafeAdditionDto;
import com.Major.majorProject.dto.OwnerRegistrationDto;
import com.Major.majorProject.entity.Cafe;
import com.Major.majorProject.entity.CafeOwner;
import com.Major.majorProject.repository.CafeOwnerRepository;
import com.Major.majorProject.repository.CafeRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final CafeOwnerRepository cafeOwnerRepository;
    private final PasswordEncoder passwordEncoder;
    private final CafeRepository cafeRepository;
    public OwnerService(CafeOwnerRepository cor, PasswordEncoder pe, CafeRepository cr){
        this.cafeOwnerRepository = cor;
        this.passwordEncoder = pe;
        this.cafeRepository = cr;
    }


    public OwnerRegistrationDto ownerRegistration(OwnerRegistrationDto ord) {
        if(cafeOwnerRepository.findByEmail(ord.getEmail()).isPresent()){
            throw new RuntimeException("This email id is already associated with other client"+ord.getEmail());
        }

        CafeOwner cafeOwner = new CafeOwner();
        cafeOwner.setName(ord.getName());
        cafeOwner.setEmail(ord.getEmail())  ;
        cafeOwner.setPhone(ord.getPhone());
        cafeOwner.setPassword(passwordEncoder.encode(ord.getPassword()));

         cafeOwnerRepository.save(cafeOwner);
         return ord;
    }

    public void cafeAddition(CafeAdditionDto cad) {
        String ownerEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        CafeOwner owner = cafeOwnerRepository.findByEmail(ownerEmail).get();

        Cafe cafe = new Cafe();
        cafe.setOwner(owner);
        cafe.setName(cad.getName());
        cafe.setAddress(cad.getAddress());
        cafe.setOpenTime(cad.getOpenTime());
        cafe.setCloseTime(cad.getCloseTime());
        cafe.setHourlyRate(cad.getHourlyRate());
        cafeRepository.save(cafe);   //try and catch maybe needed. we will see this later.
    }
}
