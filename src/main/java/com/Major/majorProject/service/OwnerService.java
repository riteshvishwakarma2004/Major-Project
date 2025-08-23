package com.Major.majorProject.service;

import com.Major.majorProject.dto.OwnerRegistrationDto;
import com.Major.majorProject.entity.CafeOwner;
import com.Major.majorProject.repository.CafeOwnerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final CafeOwnerRepository cafeOwnerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerService(CafeOwnerRepository cor, PasswordEncoder pe){
        this.cafeOwnerRepository = cor;
        this.passwordEncoder = pe;
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
}
