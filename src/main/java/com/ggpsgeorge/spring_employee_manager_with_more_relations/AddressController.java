package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/addresses")
public class AddressController {
    
    @Autowired AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return ResponseEntity.ok().body(addressService.saveAddress(address));
    }

}
